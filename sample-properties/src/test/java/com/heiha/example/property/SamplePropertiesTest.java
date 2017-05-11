package com.heiha.example.property;

import com.heiha.example.SamplePropertiesApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/9 10:39<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SamplePropertiesApplication.class)
@EnableConfigurationProperties(SampleProperties.class)
public class SamplePropertiesTest {
    @Autowired
    private SampleProperties properties;

    @Test
    public void print() {
        System.out.println(properties.getHost());
        System.out.println(properties.getPort());
        System.out.println(properties.getPassword());

        System.out.println(properties.getPool().getMaxActive());
        System.out.println(properties.getPool().getMaxIdle());
    }
}