package com.damai.service.strategy;

import com.damai.dto.ProgramOrderCreateDto;

/**
 * @program:   
 * @description: 节目订单策略
 * @author:  旷智仁
 **/
public interface ProgramOrderStrategy {
    
    /**
     * 创建订单
     * @param programOrderCreateDto 订单参数
     * @return 订单编号
     * */
    String createOrder(ProgramOrderCreateDto programOrderCreateDto);
}
