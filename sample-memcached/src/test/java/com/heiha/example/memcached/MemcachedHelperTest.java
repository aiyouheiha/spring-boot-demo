package com.heiha.example.memcached;

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
 * <b>Date:</b> 2017/5/18 11:32<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMemcachedApplication.class)
public class MemcachedHelperTest {
    @Autowired
    private MemcachedHelper memcachedHelper;

    @Test
    public void testUse() throws Exception {
        memcachedHelper.use();
    }
}