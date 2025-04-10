package com.damai.client;

import com.damai.common.ApiResponse;
import com.damai.dto.AccountOrderCountDto;
import com.damai.dto.OrderCreateDto;
import com.damai.vo.AccountOrderCountVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import static com.damai.constant.Constant.SPRING_INJECT_PREFIX_DISTINCTION_NAME;

/**
 * @program:
 * @description: 订单服务 feign
 * @author:  旷智仁
 **/
@Component
@FeignClient(value = SPRING_INJECT_PREFIX_DISTINCTION_NAME+"-"+"order-service",fallback = OrderClientFallback.class)
public interface OrderClient {
    
    /**
     * 创建订单
     * @param dto 参数
     * @return 结果
     * */
    @PostMapping("/order/create")
    ApiResponse<String> create(OrderCreateDto dto);
    
    /**
     * 账户下某个节目的订单数量
     * @param dto 参数
     * @return 结果
     * */
    @PostMapping("/order/account/order/count")
    ApiResponse<AccountOrderCountVo> accountOrderCount(AccountOrderCountDto dto);
}
