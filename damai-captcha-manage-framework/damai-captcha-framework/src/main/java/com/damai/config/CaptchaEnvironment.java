package com.damai.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @program:
 * @description: 环境配置
 * @author:  旷智仁
 **/
public class CaptchaEnvironment implements EnvironmentPostProcessor {
    
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        application.setAllowBeanDefinitionOverriding(true);
    }
}
