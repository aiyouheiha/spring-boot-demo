package com.heiha.example.springboot.psql.repository.impl;

import com.alibaba.fastjson.JSON;
import com.heiha.example.springboot.SamplePsqlMybatisApplication;
import com.heiha.example.springboot.psql.po.TTest;
import com.heiha.example.springboot.psql.repository.TTestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/2 17:58<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SamplePsqlMybatisApplication.class)
public class TTestRepositoryImplTest {
    @Autowired
    private TTestRepository tTestRepository;

    @Test
    public void testSave() throws Exception {
        for (int i=10; i<20; i++) {
            System.out.println(tTestRepository.save(new TTest(i, String.valueOf(Character.toChars('c' + i)))));
        }
    }

    @Test
    public void testRemove() throws Exception {
        TTest tTest = new TTest();
        tTest.setId(7);
        System.out.println(tTestRepository.remove(tTest));
    }

    @Test
    public void testUpdate() throws Exception {
        TTest tTest = new TTest();
        tTest.setId(8);
        tTest.setName("update");
        System.out.println(tTestRepository.update(tTest));
    }

    @Test
    public void testGet() throws Exception {
        TTest tTest = new TTest();
        tTest.setName("u");
        System.out.println(JSON.toJSONString(tTestRepository.get(tTest)));
    }
}