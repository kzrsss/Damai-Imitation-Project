package com.damai.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @program:   
 * @description: kafka 生产者配置
 * @author:  旷智仁
 **/
@ConditionalOnProperty(value = "spring.kafka.bootstrap-servers")
public class ProducerConfig {
    
    @Bean
    public KafkaTopic kafkaTopic(){
        return new KafkaTopic();
    }
    
    @Bean
    public ApiDataMessageSend apiDataMessageSend(KafkaTemplate<String, String> kafkaTemplate, KafkaTopic kafkaTopic){
        return new ApiDataMessageSend(kafkaTemplate, kafkaTopic.getTopic());
    }
}
