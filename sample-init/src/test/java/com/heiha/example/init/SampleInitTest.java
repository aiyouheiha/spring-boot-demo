package com.heiha.example.init;

import com.heiha.example.SampleInitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-05-15 02:48
 * <b>Author:</b> heiha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleInitApplication.class)
public class SampleInitTest {
    @Autowired
    private SampleInit sampleInit;

    @Test
    public void testDoSomething() throws Exception {
        sampleInit.doSomething();
    }
}