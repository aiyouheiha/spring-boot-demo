package com.heiha.example.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/15 9:51<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class SampleInit3 implements InitializingBean, Sample {
    @Override
    public void afterPropertiesSet() throws Exception {
        SampleInitUtil.before(this.getClass(), "afterPropertiesSet");
    }

    @PostConstruct
    public void init() {
        SampleInitUtil.before(this.getClass(), "init");
    }

    @Override
    public void doSomething() {
        SampleInitUtil.doSomething(this.getClass());
    }
}
