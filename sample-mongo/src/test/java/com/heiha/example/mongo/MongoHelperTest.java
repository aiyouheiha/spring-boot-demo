package com.heiha.example.mongo;

import com.heiha.example.SampleMongoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/17 17:33<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMongoApplication.class)
public class MongoHelperTest {
    @Autowired
    private MongoHelper mongoHelper;

    @Test
    public void testUse() throws Exception {
        mongoHelper.use();
    }
}