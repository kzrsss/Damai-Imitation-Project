package com.damai.initialize.execute;

import com.damai.initialize.execute.base.AbstractApplicationExecute;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.annotation.PostConstruct;

import static com.damai.initialize.constant.InitializeHandlerType.APPLICATION_POST_CONSTRUCT;

/**
 * @program:
 * @description: 用于处理 {@link PostConstruct} 应用程序启动事件。
 * @author:  旷智仁
 **/
public class ApplicationPostConstructExecute extends AbstractApplicationExecute {
    
    public ApplicationPostConstructExecute(ConfigurableApplicationContext applicationContext){
        super(applicationContext);
    }
    
    @PostConstruct
    public void postConstructExecute() {
        execute();
    }
    
    @Override
    public String type() {
        return APPLICATION_POST_CONSTRUCT;
    }
}
