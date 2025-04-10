package com.damai.initialize.base;

import org.springframework.boot.CommandLineRunner;

import static com.damai.initialize.constant.InitializeHandlerType.APPLICATION_COMMAND_LINE_RUNNER;
import static com.damai.initialize.constant.InitializeHandlerType.APPLICATION_POST_CONSTRUCT;

/**
 * @program:   
 * @description: 用于处理 {@link CommandLineRunner} 类型 初始化执行 抽象
 * @author:  旷智仁
 **/
public abstract class AbstractApplicationCommandLineRunnerHandler implements InitializeHandler {
    
    @Override
    public String type() {
        return APPLICATION_COMMAND_LINE_RUNNER;
    }
}
