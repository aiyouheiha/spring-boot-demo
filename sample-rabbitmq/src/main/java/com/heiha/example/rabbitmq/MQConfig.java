package com.heiha.example.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/9/11 19:30<br>
 * <b>Author:</b> heiha<br>
 */
@Configuration
public class MQConfig {
    @Bean
    public Queue queue() {
        return new Queue("heiha.test.queue");
    }
}
