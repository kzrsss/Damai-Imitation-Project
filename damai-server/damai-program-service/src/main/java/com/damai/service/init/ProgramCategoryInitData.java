package com.damai.service.init;

import com.damai.BusinessThreadPool;
import com.damai.initialize.base.AbstractApplicationPostConstructHandler;
import com.damai.service.ProgramCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
/**
 * @program:
 * @description: 节目种类缓存
 * @author:  旷智仁
 **/
@Component
public class ProgramCategoryInitData extends AbstractApplicationPostConstructHandler {
    
    @Autowired
    private ProgramCategoryService programCategoryService;
    
    
    @Override
    public Integer executeOrder() {
        return 1;
    }
    
    @Override
    public void executeInit(final ConfigurableApplicationContext context) {
        BusinessThreadPool.execute(() -> {
            programCategoryService.programCategoryRedisDataInit();
        });
    }
}
