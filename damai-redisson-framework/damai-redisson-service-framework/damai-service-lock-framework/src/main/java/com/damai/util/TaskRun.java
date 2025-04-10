package com.damai.util;

/**
 * @program:   
 * @description: 分布式锁 方法类型执行 无返回值的业务
 * @author:  旷智仁
 **/
@FunctionalInterface
public interface TaskRun {
    
    /**
     * 执行任务
     * */
    void run();
}
