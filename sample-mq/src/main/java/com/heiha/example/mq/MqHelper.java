package com.heiha.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/17 18:36<br>
 * <b>Author:</b> heiha<br>
 *
 * @see org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties
 * @see org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration
 */
@Component
public class MQHelper {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void use() {

    }
}
