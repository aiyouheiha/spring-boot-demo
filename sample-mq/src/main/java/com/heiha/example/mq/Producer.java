package com.heiha.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/22 18:34<br>
 * <b>Author:</b> heiha<br>
 */
@Service
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
