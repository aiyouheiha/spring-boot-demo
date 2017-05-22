package com.heiha.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/22 18:34<br>
 * <b>Author:</b> heiha<br>
 */
@Component
@EnableScheduling
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    // 每3s执行1次
    @Scheduled(fixedDelay = 3000)
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ");
    }
}
