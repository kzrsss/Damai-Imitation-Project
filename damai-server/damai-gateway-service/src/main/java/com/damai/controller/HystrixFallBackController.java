package com.damai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program:
 * @description: 熔断
 * @author:  旷智仁
 **/
@RestController
public class HystrixFallBackController {

    @RequestMapping(value = "/fallBackHandler")
    public String fallBackHandler(){
        return "熔断器执行";
    }
}
