package com.damai.context.config;

import com.damai.context.ContextHandler;
import com.damai.context.impl.WebMvcContextHandler;
import org.springframework.context.annotation.Bean;

/**
 * @program:
 * @description: WebMvc配置
 * @author:  旷智仁
 **/
public class WebMvcContextAutoConfiguration {
    
    @Bean
    public ContextHandler webMvcContext(){
        return new WebMvcContextHandler();
    }
}
