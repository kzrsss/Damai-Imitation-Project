package com.damai.config;

import com.damai.monitor.DingTalkMessage;
import com.damai.monitor.MonitorServer;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program:   
 * @description: 服务监控 配置
 * @author:  旷智仁
 **/
@Configuration
public class MonitorServerConfig {
    
    @Value("${dingtalk.token:}")
    private String token;
    
    @Bean
    public DingTalkMessage dingTalkMessage(){
        return new DingTalkMessage(token);
    }
    
    @Bean
    public MonitorServer monitorServer(DingTalkMessage dingTalkMessage,InstanceRepository repository){
        return new MonitorServer(dingTalkMessage,repository);
    }
    
    
}
