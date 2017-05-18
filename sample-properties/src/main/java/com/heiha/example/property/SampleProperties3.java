package com.heiha.example.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/10 17:15<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "sample", name = "host")
@Component
public class SampleProperties3 {
    @Autowired
    private Environment env;

    public void show() {
        System.out.println(env.getProperty("sample.host", "localhost"));
        System.out.println(env.getProperty("sample.port"));
        System.out.println(env.getProperty("sample.password"));
        System.out.println(env.getProperty("sample.pool.max-active", "0"));
        System.out.println(env.getProperty("sample.pool.max-idle", "0"));
    }
}
