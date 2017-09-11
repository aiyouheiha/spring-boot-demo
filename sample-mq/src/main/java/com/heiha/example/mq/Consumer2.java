package com.heiha.example.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/9/11 10:20<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class Consumer2 {
    @JmsListener(destination = "heiha.test.queue")
    public void receive(String text) {
        System.out.println(Thread.currentThread().getName().concat(" - Consumer2 - ") + text);
    }
}
