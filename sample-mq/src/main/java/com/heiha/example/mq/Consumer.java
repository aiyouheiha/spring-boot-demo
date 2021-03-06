package com.heiha.example.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/22 18:38<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class Consumer {
    @JmsListener(destination = "heiha.test.queue")
    public void receive(String text) {
        System.out.println(Thread.currentThread().getName().concat(" - Consumer - ") + text);
    }
}
