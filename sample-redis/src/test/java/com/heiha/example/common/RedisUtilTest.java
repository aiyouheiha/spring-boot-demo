package com.heiha.example.common;

import org.junit.Before;
import org.junit.Test;
import com.heiha.example.SampleRedisApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/8 15:00<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleRedisApplication.class)
@WebAppConfiguration
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Before
    public void before() {
    }

    @Test
    public void testSetIfAbsent() {
        System.out.println(redisUtil.setIfAbsent("test", "test1"));
    }

    @Test
    public void testGet() {
        System.out.println(redisUtil.get("test"));
    }

    @Test
    public void testDelete() {
        redisUtil.delete("test");
    }

    @Test
    public void testGetAndSet() {
        System.out.println(redisUtil.getAndSet("test", "test2"));
    }
}