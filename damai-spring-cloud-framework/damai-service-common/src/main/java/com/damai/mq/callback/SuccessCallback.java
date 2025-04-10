package com.damai.mq.callback;

/**
 * @program:
 * @description: 用于执行成功的情况
 * @author:  旷智仁
 **/
@FunctionalInterface
public interface SuccessCallback<T> {
    
    /**
     * 执行逻辑
     * @param result 执行成功的结果当做参数传递
     * */
    void onSuccess(T result);

}
