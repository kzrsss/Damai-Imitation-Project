package com.damai.core;

import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description: 延迟队列 延迟队列
 * @author:  旷智仁
 **/
public class DelayProduceQueue extends DelayBaseQueue{
    
    private final RDelayedQueue<String> delayedQueue;
    public DelayProduceQueue(RedissonClient redissonClient, final String relTopic) {
        super(redissonClient, relTopic);
        this.delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
    }
    
    public void offer(String content, long delayTime, TimeUnit timeUnit) {
        delayedQueue.offer(content,delayTime,timeUnit);
    }
}
