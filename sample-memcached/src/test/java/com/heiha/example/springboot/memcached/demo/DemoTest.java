package com.heiha.example.springboot.memcached.demo;

import com.heiha.example.SampleMemcachedApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/4 19:39<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMemcachedApplication.class)
public class DemoTest {
    @Autowired
    private Demo demo;

    @Test
    public void testUse() throws Exception {
        demo.use();
    }
}