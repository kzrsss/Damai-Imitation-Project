package com.damai.kafka;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @program:
 * @description: kafka topic
 * @author:  旷智仁
 **/
@Data
public class KafkaTopic {
    
    @Value("${spring.kafka.topic:default}")
    private String topic;

}
