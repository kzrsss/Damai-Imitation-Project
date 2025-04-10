package com.damai.servicelock.factory;

import com.damai.core.ManageLocker;
import com.damai.servicelock.LockType;
import com.damai.servicelock.ServiceLocker;
import lombok.AllArgsConstructor;

/**
 * @program:
 * @description: 分布式锁类型工厂
 * @author:  旷智仁
 **/
@AllArgsConstructor
public class ServiceLockFactory {
    
    private final ManageLocker manageLocker;
    

    public ServiceLocker getLock(LockType lockType){
        ServiceLocker lock;
        switch (lockType) {
            case Fair:
                lock = manageLocker.getFairLocker();
                break;
            case Write:
                lock = manageLocker.getWriteLocker();
                break;
            case Read:
                lock = manageLocker.getReadLocker();
                break;
            default:
                lock = manageLocker.getReentrantLocker();
                break;
        }
        return lock;
    }
}
