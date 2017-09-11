package com.heiha.example.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/9/11 14:18<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class Consumer {

    @RabbitListener(queues = "heiha.test.queue")
    @RabbitHandler
    public void process(@Payload String message) {
        System.out.println("Listener: " + message);
    }
}
