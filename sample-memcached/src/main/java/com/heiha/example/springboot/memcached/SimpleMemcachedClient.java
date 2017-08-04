package com.heiha.example.springboot.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/4 9:49<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "memcached", name = "address")
@Component
public class SimpleMemcachedClient<T> implements InitializingBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleMemcachedClient.class);
    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private Environment environment;

    private MemcachedClientBuilder builder;
    private volatile MemcachedClient memcachedClient = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        builder = new XMemcachedClientBuilder(
                AddrUtil.getAddresses(environment.getProperty("memcached.address")));
    }

    public MemcachedClient getMemcachedClient() {
        if (memcachedClient == null) {
            try {
                lock.lock();
                if (memcachedClient == null) {
                    builder.setConnectionPoolSize(99);
                    memcachedClient = builder.build();
                }
            } catch (IOException e) {
                LOGGER.error("connect memcached server failed", e);
                return null;
            } finally {
                lock.unlock();
            }
        }
        return memcachedClient;
    }

    public void saveToCache(String key, T value) {
        LOGGER.debug("saveToCache(key:{},value{})", key, value);
        try {
            getMemcachedClient().set(key, 0, value);
        } catch (Exception e) {
            LOGGER.error("save data to memcached error", e);
        }
    }

    public void saveToCache(String key, int exp, T value) {
        LOGGER.debug("saveToCache(key:{},value{})", key, value);
        try {
            getMemcachedClient().set(key, exp, value);
        } catch (Exception e) {
            LOGGER.error("save data to memcached error",e);
        }
    }

    public T getFromCache(String key) {
        LOGGER.debug("getFromCache(key:{})", key);
        try {
            return getMemcachedClient().get(key);
        } catch (Exception e) {
            LOGGER.error("get data from memcached error", e);
        }
        return null;
    }

    public boolean removeFromCache(String key) {
        LOGGER.debug("removeFromCache(key:{})", key);
        try {
            return getMemcachedClient().delete(key);
        } catch (Exception e) {
            LOGGER.error("delete data from memcached error", e);
        }
        return false;
    }
}
