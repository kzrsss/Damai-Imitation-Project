package com.damai.balance.config;

import com.damai.context.ContextHandler;
import com.damai.enhance.config.EnhanceLoadBalancerClientConfiguration;
import com.damai.enhance.config.EnhanceLoadBalancerClientConfiguration.BlockingSupportConfiguration;
import com.damai.enhance.config.EnhanceLoadBalancerClientConfiguration.ReactiveSupportConfiguration;
import com.damai.filter.AbstractServerFilter;
import com.damai.filter.impl.ServerGrayFilter;
import com.damai.fiterbalance.DefaultFilterLoadBalance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @program:
 * @description: 灰度版本选择相关配置
 * @author:  旷智仁
 **/
@LoadBalancerClients(defaultConfiguration = {EnhanceLoadBalancerClientConfiguration.class, ReactiveSupportConfiguration.class, BlockingSupportConfiguration.class})
public class GrayLoadBalanceAutoConfiguration {
    
    @Bean
    public DefaultFilterLoadBalance defaultFilterLoadBalance(List<AbstractServerFilter> strategyEnabledFilterList){
        return new DefaultFilterLoadBalance(strategyEnabledFilterList);
    }
    
    @Bean
    public AbstractServerFilter serverGrayFilter(ContextHandler contextHandler) {
        return new ServerGrayFilter(contextHandler);
    }
}
