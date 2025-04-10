package com.damai.entity;

import lombok.Data;

/**
 * @program:
 * @description: 购票人订单聚合统计 实体
 * @author:  旷智仁
 **/
@Data
public class OrderTicketUserAggregate {
    
    private Long orderNumber;
    
    private Integer orderTicketUserCount;
}
