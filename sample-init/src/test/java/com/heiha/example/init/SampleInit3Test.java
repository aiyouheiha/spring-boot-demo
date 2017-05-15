package com.heiha.example.init;

import com.heiha.example.SampleInitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/15 9:54<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleInitApplication.class)
public class SampleInit3Test {
    @Autowired
    private SampleInit3 sampleInit3;

    @Test
    public void testDoSomething() throws Exception {
        sampleInit3.doSomething();
    }
}