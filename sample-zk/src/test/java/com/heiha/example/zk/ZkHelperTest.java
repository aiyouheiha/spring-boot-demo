package com.heiha.example.zk;

import com.heiha.example.SampleZkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-05-14 23:16
 * <b>Author:</b> heiha
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleZkApplication.class)
public class ZkHelperTest {
    @Autowired
    private ZkHelper zkHelper;

    @Autowired
    private ZkTest2 zkTest2;

    @Test
    public void testUse() throws Exception {
        zkHelper.use("/test", "test data1");
    }

    @Test
    public void testZkTest2() throws Exception {
        zkTest2.use();
    }
}