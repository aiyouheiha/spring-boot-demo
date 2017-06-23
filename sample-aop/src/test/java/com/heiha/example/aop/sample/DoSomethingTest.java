package com.heiha.example.aop.sample;

import com.heiha.example.SampleAopApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 9:44<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleAopApplication.class)
public class DoSomethingTest {
    @Autowired
    private DoSomething doSomething;

    @Test
    public void testDoSomething() throws Exception {
        doSomething.doSomething();
    }

    @Test
    public void testDoSomething2() throws Exception {
        doSomething.doSomething2();
    }
}