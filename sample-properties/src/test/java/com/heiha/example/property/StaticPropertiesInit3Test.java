package com.heiha.example.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/13 11:01<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StaticPropertiesInit3.class)
public class StaticPropertiesInit3Test {

    @Test
    public void testPrint() throws Exception {
        StaticPropertiesInit3.print();
    }
}