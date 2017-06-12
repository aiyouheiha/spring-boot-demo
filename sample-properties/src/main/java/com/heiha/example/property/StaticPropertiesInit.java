package com.heiha.example.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/12 14:20<br>
 * <b>Author:</b> heiha<br>
 */
@Component
@EnableConfigurationProperties(SampleProperties.class)
public class StaticPropertiesInit {
    private static SampleProperties PROPERTIES;

    @Autowired
    private SampleProperties properties;

    @PostConstruct
    private void init() {
        PROPERTIES = properties;
    }

    public static void print() {
        System.out.println(PROPERTIES.getHost() + ":" + PROPERTIES.getPort() + "@" + PROPERTIES.getPassword());
    }
}
