package com.heiha.example.property;

import com.heiha.example.SamplePropertiesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/10 17:20<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SamplePropertiesApplication.class)
public class SampleProperties2Test {
    @Autowired
    private SampleProperties2 properties2;

    @Test
    public void print() {
        System.out.println(properties2.getHost());
        System.out.println(properties2.getPort());
        System.out.println(properties2.getPassword());

        System.out.println(properties2.getMaxActive());
        System.out.println(properties2.getMaxIdle());
    }

}