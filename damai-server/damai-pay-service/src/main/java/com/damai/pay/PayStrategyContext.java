package com.damai.pay;

import com.damai.enums.BaseCode;
import com.damai.exception.DaMaiFrameException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @program:
 * @description: 支付策略上下文
 * @author:  旷智仁
 **/
public class PayStrategyContext {
    
    private final Map<String,PayStrategyHandler> payStrategyHandlerMap = new HashMap<>();
    
    public void put(String channel,PayStrategyHandler payStrategyHandler){
        payStrategyHandlerMap.put(channel,payStrategyHandler);
    }
    
    public PayStrategyHandler get(String channel){
        return Optional.ofNullable(payStrategyHandlerMap.get(channel)).orElseThrow(
                () -> new DaMaiFrameException(BaseCode.PAY_STRATEGY_NOT_EXIST));
    }
}
