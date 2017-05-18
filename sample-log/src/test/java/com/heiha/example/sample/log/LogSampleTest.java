package com.heiha.example.sample.log;

import com.heiha.example.SampleLogApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 13:43<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleLogApplication.class)
public class LogSampleTest {
    @Autowired
    private LogSample logSample;
    private String logName;
    private String logValue;

    @Before
    public void setUp() throws Exception {
        logName = "test-name";
        logValue = "test-value";
    }

    @Test
    public void testLog() throws Exception {
        logSample.log(logName, logValue);
    }
}