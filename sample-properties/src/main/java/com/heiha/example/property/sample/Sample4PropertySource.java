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
public class Sample4PropertySource<T> {
    @Value("${test.name}")
    private String name;
    @Value("${test.test-value}")
    private T testValue;
    @Value("${test.enum-type}")
    private SampleEnumType enumType;

    public void print() {
        System.out.println(name);
        System.out.println(enumType);
    }

    public T getTest() {
        return testValue;
    }

    public T getTest2(T value) {
        return value;
    }
}
