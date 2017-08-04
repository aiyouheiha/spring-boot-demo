package com.heiha.example.springboot.memcached.demo;

import com.heiha.example.springboot.memcached.MemcachedHelper;
import com.heiha.example.springboot.memcached.SimpleMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/4 18:01<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class Demo {
    @Autowired
    private MemcachedHelper memcachedHelper;

    @Autowired
    private SimpleMemcachedClient<List<String>> memcachedClient;

    private final static String KEY = "spring.boot.demo.test.key";

    public void use() throws InterruptedException, MemcachedException, TimeoutException {
        memcachedHelper.use();
    }

    public void use2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<String>> callableList = new ArrayList<>(10);

        for (int i=0; i<10; i++) {
            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;

                }
            };
        }
    }
}
