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
 * <b>Date:</b> 2017/5/10 17:19<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SamplePropertiesApplication.class)
public class SampleProperties3Test {
    @Autowired
    private SampleProperties3 properties3;

    @Test
    public void testShow() throws Exception {
        properties3.show();
    }
}