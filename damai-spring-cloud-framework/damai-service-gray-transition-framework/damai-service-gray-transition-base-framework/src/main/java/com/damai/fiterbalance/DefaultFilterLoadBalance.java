package com.damai.fiterbalance;


import com.damai.balance.FilterLoadBalance;
import com.damai.filter.AbstractServerFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program:
 * @description: 负载均衡服务过滤接口的实现
 * @author:  旷智仁
 **/
@AllArgsConstructor
public class DefaultFilterLoadBalance implements FilterLoadBalance {

    protected final List<AbstractServerFilter> strategyFilterList;

    @Override
    public void selectServer(List<ServiceInstance> servers) {
        for (AbstractServerFilter strategyEnabledFilter : strategyFilterList) {
            strategyEnabledFilter.filter(servers);
        }
    }
}