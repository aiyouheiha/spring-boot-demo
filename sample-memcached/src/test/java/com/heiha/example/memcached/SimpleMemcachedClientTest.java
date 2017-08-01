package com.heiha.example.memcached;

import com.heiha.example.SampleMemcachedApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/1 9:29<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMemcachedApplication.class)
public class SimpleMemcachedClientTest {
    @Autowired
    private SimpleMemcachedClient memcachedClient;

    @Test
    public void test() throws InterruptedException {
        memcachedClient.saveToCache("test-1", "test msg 1");
        memcachedClient.saveToCache("test-2", 10, "test msg 2");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println((String) memcachedClient.getFromCache("test-1"));
                System.out.println((String) memcachedClient.getFromCache("test-2"));
            }).start();
        }
        System.out.println((String) memcachedClient.getFromCache("test-1"));
        System.out.println((String) memcachedClient.getFromCache("test-2"));
        Thread.sleep(10000);
        System.out.println((String) memcachedClient.getFromCache("test-1"));
        System.out.println((String) memcachedClient.getFromCache("test-2"));
        System.out.println(memcachedClient.removeFromCache("test-1"));
        System.out.println(memcachedClient.removeFromCache("test-2"));
    }
}