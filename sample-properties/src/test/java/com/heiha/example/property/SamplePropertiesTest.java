package com.heiha.example.property;

import com.heiha.example.SamplePropertiesApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/9 10:39<br>
 * <b>Author:</b> heiha<br>
 *
 * Different with {@link SampleProperties2Test} and {@link SampleProperties3Test},
 * this one could not use @ConditionalOnBean(SampleProperties.class), or errors will happen.
 */
// @ConditionalOnBean(SampleProperties.class)
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

        Map<String, Integer> map = properties.getTestMap();
        System.out.println("map size: " + map.size() +
                "\nmap test1: " + map.getOrDefault("test1", 11) +
                "\nmap test2: " + map.getOrDefault("test2", 12) +
                "\nmap test3: " + map.getOrDefault("test3", 13));
    }
}