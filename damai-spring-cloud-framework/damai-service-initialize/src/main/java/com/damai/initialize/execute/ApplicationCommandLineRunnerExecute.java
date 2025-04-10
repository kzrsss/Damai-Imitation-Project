package com.damai.initialize.execute;

import com.damai.initialize.execute.base.AbstractApplicationExecute;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

import static com.damai.initialize.constant.InitializeHandlerType.APPLICATION_COMMAND_LINE_RUNNER;

/**
 * @program:
 * @description: 用于处理 {@link CommandLineRunner} 应用程序启动事件。
 * @author:  旷智仁
 **/
public class ApplicationCommandLineRunnerExecute extends AbstractApplicationExecute implements CommandLineRunner {
    
    public ApplicationCommandLineRunnerExecute(ConfigurableApplicationContext applicationContext){
        super(applicationContext);
    }
    
    @Override
    public void run(final String... args) {
        execute();
    }
    
    @Override
    public String type() {
        return APPLICATION_COMMAND_LINE_RUNNER;
    }
}
