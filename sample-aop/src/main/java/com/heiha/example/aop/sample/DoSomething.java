package com.heiha.example.aop.sample;

import com.heiha.example.aop.annotation.DemoAnnotation;
import com.heiha.example.aop.sample.AopSample;
import com.heiha.example.aop.sample.AopSample2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 9:14<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class DoSomething {
    @Autowired
    private TestCCC testCCC;


    @Scheduled(fixedRate = 10000)
    @DemoAnnotation
    public String doSomething() throws InterruptedException {
       return testCCC.test();
    }

    @AopSample
    private String schedule() {
        System.out.println(Thread.currentThread().getName().concat(" do something start"));
        System.out.println("Do something ...");
        System.out.println(Thread.currentThread().getName().concat(" do something end"));
        return "Hello World!";
    }

    @AopSample2("value")
    public Integer doSomething2(String input) {
        System.out.println("Do something 2 ..." + input);
        return 123;
    }

    @SampleAnnotation
    public String doSomething3(String input) {
        System.out.println(input);
        return input;
    }

}
