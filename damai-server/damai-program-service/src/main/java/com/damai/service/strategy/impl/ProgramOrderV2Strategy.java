package com.damai.service.strategy.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.damai.core.RepeatExecuteLimitConstants;
import com.damai.dto.ProgramOrderCreateDto;
import com.damai.dto.SeatDto;
import com.damai.enums.CompositeCheckType;
import com.damai.enums.ProgramOrderVersion;
import com.damai.initialize.base.AbstractApplicationCommandLineRunnerHandler;
import com.damai.initialize.impl.composite.CompositeContainer;
import com.damai.locallock.LocalLockCache;
import com.damai.repeatexecutelimit.annotion.RepeatExecuteLimit;
import com.damai.service.ProgramOrderService;
import com.damai.service.strategy.ProgramOrderContext;
import com.damai.service.strategy.ProgramOrderStrategy;
import com.damai.servicelock.LockType;
import com.damai.util.ServiceLockTool;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static com.damai.core.DistributedLockConstants.PROGRAM_ORDER_CREATE_V2;

/**
 * @program:
 * @description: 节目订单v2
 * @author:  旷智仁
 **/
@Slf4j
@Component
public class ProgramOrderV2Strategy extends AbstractApplicationCommandLineRunnerHandler implements ProgramOrderStrategy {
    
    @Autowired
    private ProgramOrderService programOrderService;
    
    @Autowired
    private ServiceLockTool serviceLockTool;
    
    @Autowired
    private CompositeContainer compositeContainer;
    
    @Autowired
    private LocalLockCache localLockCache;

    /**
     * 订单优化版本v2
     * 先用本地锁将没有获得锁的请求拦在外，获得本地锁后，再去获得分布式锁，这样可以减少对redis的压力
     * 本地锁和分布式锁的键为 节目id+票档id，这样同一节目下不同票档的用户请求依旧可以并发执行
     */
    @RepeatExecuteLimit(
            name = RepeatExecuteLimitConstants.CREATE_PROGRAM_ORDER,
            keys = {"#programOrderCreateDto.userId","#programOrderCreateDto.programId"})
    @Override
    public String createOrder(ProgramOrderCreateDto programOrderCreateDto) {
        //这行代码调用了一个验证工具（compositeContainer），对输入的订单创建参数进行校验，确保参数合法。
        compositeContainer.execute(CompositeCheckType.PROGRAM_ORDER_CREATE_CHECK.getValue(),programOrderCreateDto);
        //票档ID的统计
        //逻辑：
        //如果用户手动选择了座位（seatDtoList 不为空），则从座位信息中提取票档ID，并去重。
        //如果用户没有手动选择座位（自动匹配座位），则直接使用传入的票档ID。
        //目的：确定需要加锁的票档ID集合。
        List<SeatDto> seatDtoList = programOrderCreateDto.getSeatDtoList();
        List<Long> ticketCategoryIdList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(seatDtoList)) {
            ticketCategoryIdList =
                    seatDtoList.stream().map(SeatDto::getTicketCategoryId).distinct().collect(Collectors.toList());
        }else {
            ticketCategoryIdList.add(programOrderCreateDto.getTicketCategoryId());
        }

        //锁的初始化
        //初始化了四个锁集合：
        //localLockList：存储所有本地锁实例。
        //serviceLockList：存储所有分布式锁实例。
        //localLockSuccessList：存储加锁成功的本地锁。
        //serviceLockSuccessList：存储加锁成功的分布式锁。
        List<ReentrantLock> localLockList = new ArrayList<>(ticketCategoryIdList.size());
        List<RLock> serviceLockList = new ArrayList<>(ticketCategoryIdList.size());
        List<ReentrantLock> localLockSuccessList = new ArrayList<>(ticketCategoryIdList.size());
        List<RLock> serviceLockSuccessList = new ArrayList<>(ticketCategoryIdList.size());


        // 获取锁实例
        //逻辑：
        //遍历票档ID集合。
        //生成锁的键值（lockKey），格式为："d_program_order_create_v2_lock-节目ID-票档ID"。
        //通过锁的键值获取本地锁和分布式锁实例。
        //将锁实例分别添加到对应的锁集合中。
        for (Long ticketCategoryId : ticketCategoryIdList) {
            String lockKey = StrUtil.join("-",PROGRAM_ORDER_CREATE_V2,
                    programOrderCreateDto.getProgramId(),ticketCategoryId);
            ReentrantLock localLock = localLockCache.getLock(lockKey,false);
            RLock serviceLock = serviceLockTool.getLock(LockType.Reentrant, lockKey);
            localLockList.add(localLock);
            serviceLockList.add(serviceLock);
        }

        // 循环本地锁进行加锁
        for (ReentrantLock reentrantLock : localLockList) {
            try {
                reentrantLock.lock();
            }catch (Throwable t) {
                break;// 如果加锁出现异常，则终止
            }
            localLockSuccessList.add(reentrantLock);
        }

        // 循环分布式锁进行加锁
        for (RLock rLock : serviceLockList) {
            try {
                rLock.lock();
            }catch (Throwable t) {
                break;// 如果加锁出现异常，则终止
            }
            serviceLockSuccessList.add(rLock);
        }
        try {
            //订单创建
            return programOrderService.create(programOrderCreateDto);
        }finally {
            // 先循环解锁分布式锁
            for (int i = serviceLockSuccessList.size() - 1; i >= 0; i--) {
                RLock rLock = serviceLockSuccessList.get(i);
                try {
                    rLock.unlock();
                }catch (Throwable t) {
                    log.error("service lock unlock error",t);
                }
            }

            // 再循环解锁本地锁
            for (int i = localLockSuccessList.size() - 1; i >= 0; i--) {
                ReentrantLock reentrantLock = localLockSuccessList.get(i);
                try {
                    reentrantLock.unlock();
                }catch (Throwable t) {
                    log.error("local lock unlock error",t);
                }
            }
        }
    }
    
    @Override
    public Integer executeOrder() {
        return 2;
    }
    
    @Override
    public void executeInit(final ConfigurableApplicationContext context) {
        ProgramOrderContext.add(ProgramOrderVersion.V2_VERSION.getVersion(),this);
    }
}
