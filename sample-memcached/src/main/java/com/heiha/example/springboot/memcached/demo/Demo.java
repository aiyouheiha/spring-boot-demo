package com.heiha.example.springboot.memcached.demo;

import com.heiha.example.springboot.memcached.MemcachedHelper;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void use() throws InterruptedException, MemcachedException, TimeoutException {
        memcachedHelper.use();
    }
}
