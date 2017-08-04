package com.heiha.example.property.sample;

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
 * <b>Date:</b> 2017/7/19 9:42<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SamplePropertiesApplication.class)
public class Sample4PropertySourceTest {
    @Autowired
    private Sample4PropertySource<String> sample4PropertySource;

    @Autowired
    private Sample4PropertySource<Long> sample4PropertySource2;

    @Test
    public void testPrint() throws Exception {
        sample4PropertySource.print();
        System.out.println(sample4PropertySource.getTest());
        System.out.println(sample4PropertySource.getTest2("123456L"));
        System.out.println(sample4PropertySource.getTest2("123456L").getClass());

        sample4PropertySource2.print();
        System.out.println(sample4PropertySource2.getTest());
        System.out.println(sample4PropertySource2.getTest2(123456L));
        System.out.println(sample4PropertySource2.getTest2(123456L).getClass());

        System.out.println(sample4PropertySource.hashCode());
        System.out.println(sample4PropertySource2.hashCode());
    }
}