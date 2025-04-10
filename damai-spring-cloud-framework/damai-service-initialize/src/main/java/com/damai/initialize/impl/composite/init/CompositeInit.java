package com.damai.initialize.impl.composite.init;

import com.damai.initialize.base.AbstractApplicationStartEventListenerHandler;
import com.damai.initialize.impl.composite.CompositeContainer;
import lombok.AllArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program:
 * @description: 组合模式初始化操作执行
 * @author:  旷智仁
 **/
@AllArgsConstructor
public class CompositeInit extends AbstractApplicationStartEventListenerHandler {
    
    private final CompositeContainer compositeContainer;
    
    @Override
    public Integer executeOrder() {
        return 1;
    }
    
    @Override
    public void executeInit(ConfigurableApplicationContext context) {
        compositeContainer.init(context);
    }
}
