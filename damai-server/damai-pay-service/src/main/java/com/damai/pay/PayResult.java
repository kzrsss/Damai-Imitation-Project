package com.damai.pay;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program:
 * @description: 支付结果
 * @author:  旷智仁
 **/
@Data
@AllArgsConstructor
public class PayResult {
    
    private final boolean success;
    
    private final String body;
}
