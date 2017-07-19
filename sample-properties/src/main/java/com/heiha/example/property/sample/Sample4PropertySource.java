package com.heiha.example.property.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/19 9:36<br>
 * <b>Author:</b> heiha<br>
 */
@Component
@PropertySource("classpath:${sample.property.location}/test.properties")
public class Sample4PropertySource {
    @Value("${test.name}")
    private String name;

    public void print() {
        System.out.println(name);
    }
}
