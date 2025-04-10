package com.damai.service.delaysend;

import com.damai.context.DelayQueueContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program:
 * @description: 延迟订单发送
 * @author:  旷智仁
 **/
@Slf4j
@Component
public class DelayOrderCancelSend {
    
    @Autowired
    private DelayQueueContext delayQueueContext;
    
    public void sendMessage(String message){
//        try {
//            log.info("延迟订单取消消息进行发送 消息体 : {}",message);
//            delayQueueContext.sendMessage(SpringUtil.getPrefixDistinctionName() + "-" + DELAY_ORDER_CANCEL_TOPIC,
//                    message, DELAY_ORDER_CANCEL_TIME, DELAY_ORDER_CANCEL_TIME_UNIT);
//        }catch (Exception e) {
//            log.error("send message error message : {}",message,e);
//        }
        
    }
}
