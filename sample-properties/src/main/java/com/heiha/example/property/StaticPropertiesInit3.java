package com.heiha.example.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/13 10:56<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class StaticPropertiesInit3 {
    @Autowired
    private Environment environment;

    private static Environment ENV;

    @PostConstruct
    private void init() {
        ENV = environment;
    }

    public static void print() {
        System.out.println(ENV.getProperty("sample.host") + ":" + ENV.getProperty("sample.port"));
    }
}
