package com.damai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * @program:   
 * @description: 定制化服务启动
 * @author:  旷智仁
 **/
@MapperScan({"com.damai.mapper"})
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CustomizeApplication {

    public static void main(String[] args) {
        System.setProperty("nacos.logging.default.config.enabled","false");
        SpringApplication.run(CustomizeApplication.class, args);
    }

}
