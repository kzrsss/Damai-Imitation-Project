package com.damai.balance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program:   
 * @description: 负载均衡服务过滤接口
 * @author:  旷智仁
 **/
public interface FilterLoadBalance {
    
    /**
     * 服务过滤操作
     * @param servers 服务列表
     * */
    void selectServer(List<ServiceInstance> servers);
}
