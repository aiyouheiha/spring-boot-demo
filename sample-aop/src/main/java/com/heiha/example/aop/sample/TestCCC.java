package com.heiha.example.aop.sample;

import com.heiha.example.aop.annotation.DemoAnnotation;
import org.springframework.stereotype.Component;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-08-07 23:52
 * <b>Author:</b> heiha
 */
@Component
public class TestCCC {
    @DemoAnnotation
    public String test() throws InterruptedException {
        Thread.sleep(11000);
        System.out.println("test");
        return "test";
    }
}
