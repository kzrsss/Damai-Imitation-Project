package com.damai.rejectedexecutionhandler;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program:   
 * @description: 拒绝策略
 * @author:  旷智仁
 **/
public class ThreadPoolRejectedExecutionHandler {
    
    
    public static class BusinessAbortPolicy implements RejectedExecutionHandler {

        public BusinessAbortPolicy() {
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            throw new RejectedExecutionException("threadPoolApplicationName business task " + r.toString() +
                    " rejected from " +
                    executor.toString());
        }
    }
}
