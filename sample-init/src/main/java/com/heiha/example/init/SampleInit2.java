package com.heiha.example.init;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-05-15 02:44
 * <b>Author:</b> heiha
 */
@Component
public class SampleInit2 implements Sample {
    @PostConstruct
    public void init() {
        SampleInitUtil.before(this.getClass(), "init");
    }

    @Override
    public void doSomething() {
        SampleInitUtil.doSomething(this.getClass());
    }
}
