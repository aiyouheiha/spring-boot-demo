package com.heiha.example.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/9/11 14:06<br>
 * <b>Author:</b> heiha<br>
 */
@Service
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queue, String message) {
        rabbitTemplate.convertAndSend(queue, message);
    }

}
