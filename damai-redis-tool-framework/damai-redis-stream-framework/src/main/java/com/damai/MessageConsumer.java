package com.damai;

import org.springframework.data.redis.connection.stream.ObjectRecord;

/**
 * @program:
 * @description: redis-stream消息处理
 * @author:  旷智仁
 **/
@FunctionalInterface
public interface MessageConsumer {
    
    /**
     * 消息处理
     * @param message 消息
     * 
     * */
    void accept(ObjectRecord<String, String> message);
}