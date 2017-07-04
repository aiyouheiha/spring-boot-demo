package com.heiha.example.aop.sample;

import com.heiha.example.aop.sample.AopSample;
import com.heiha.example.aop.sample.AopSample2;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 9:14<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class DoSomething {

    @AopSample
    public String doSomething() {
        System.out.println("Do something ...");
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
