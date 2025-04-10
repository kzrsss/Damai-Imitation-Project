package com.damai.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @program:
 * @description: 通用配置
 * @author:  旷智仁
 **/

public class DaMaiCommonAutoConfig {
    
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustom(){
        return new JacksonCustom();
    }
}
