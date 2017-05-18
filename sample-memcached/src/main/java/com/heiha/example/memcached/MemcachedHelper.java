package com.heiha.example.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 11:08<br>
 * <b>Author:</b> heiha<br>
 */
@Component
@EnableConfigurationProperties(MemcachedProperties.class)
public class MemcachedHelper implements InitializingBean {
    @Autowired
    private MemcachedProperties properties;

    private MemcachedClient memcachedClient;

    public void use() throws InterruptedException, MemcachedException, TimeoutException {
        memcachedClient.add("test", 0, "test");
        System.out.println((String)memcachedClient.get("test"));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        memcachedClient = new XMemcachedClientBuilder(properties.getHost()).build();
    }
}
