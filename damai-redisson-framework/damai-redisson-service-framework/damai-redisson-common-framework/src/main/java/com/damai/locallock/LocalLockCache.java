package com.damai.locallock;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program:
 * @description: 本地锁缓存，根据lockKey从缓存中查找锁实例。
 * 如果缓存中不存在锁实例，则根据fair参数创建一个新的ReentrantLock实例，并将其存入缓存。
 * 最终返回锁实例。
 * @author:  旷智仁
 **/
public class LocalLockCache {
    
    /**
     * 本地锁缓存
     * */
    private Cache<String, ReentrantLock> localLockCache;
    /**
     * 本地锁的过期时间(小时单位)
     * */
    @Value("${durationTime:48}")
    private Integer durationTime;


    //该方法会在依赖注入完成后执行，通常用于初始化操作
    @PostConstruct
    public void localLockCacheInit(){
        localLockCache = Caffeine.newBuilder()
                .expireAfterWrite(durationTime, TimeUnit.HOURS)
                .build();
    }
    
    /**
     * 获得锁，Caffeine的get是线程安全的
     * */
    public ReentrantLock getLock(String lockKey,boolean fair){
        return localLockCache.get(lockKey, key -> new ReentrantLock(fair));
    }
}
