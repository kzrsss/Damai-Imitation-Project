package com.damai.config;

import com.damai.properties.AjCaptchaProperties;
import com.damai.captcha.service.CaptchaCacheService;
import com.damai.captcha.service.impl.CaptchaServiceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program:
 * @description: 存储策略自动配置
 * @author:  旷智仁
 **/
@Configuration
public class AjCaptchaStorageAutoConfiguration {

    @Bean(name = "AjCaptchaCacheService")
    @ConditionalOnMissingBean
    public CaptchaCacheService captchaCacheService(AjCaptchaProperties config){
        //缓存类型redis/local/....
        return CaptchaServiceFactory.getCache(config.getCacheType().name());
    }
}
