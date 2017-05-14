package com.heiha.example.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-05-15 02:38
 * <b>Author:</b> heiha
 */
@Component
public class SampleInit implements InitializingBean, Sample {
    @Override
    public void afterPropertiesSet() throws Exception {
        SampleInitUtil.before(this.getClass());
    }

    @Override
    public void doSomething() {
        SampleInitUtil.doSomething(this.getClass());
    }
}
