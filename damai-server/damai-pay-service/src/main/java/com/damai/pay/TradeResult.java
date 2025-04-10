package com.damai.pay;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program:
 * @description: 支付状态查询 实体
 * @author:  旷智仁
 **/
@Data
public class TradeResult {
    
    private boolean success;
    
    private Integer payBillStatus;
    
    private String outTradeNo;
    
    private BigDecimal totalAmount;
}
