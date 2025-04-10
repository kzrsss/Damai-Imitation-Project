package com.damai.core;

/**
 * @program:
 * @description: 延迟队列 消费者接口
 * @author:  旷智仁
 **/
public interface ConsumerTask {
    
    /**
     * 消费任务
     * @param content 具体参数
     * */
    void execute(String content);
    /**
     * 主题
     * @return 主题
     * */
    String topic();
}
