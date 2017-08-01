package com.heiha.example.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/19 18:14<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class SimpleMemcachedClient implements InitializingBean {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleMemcachedClient.class);
    private ReentrantLock LOCK = new ReentrantLock();

    @Autowired
    private Environment environment;

    private MemcachedClientBuilder builder;
    private volatile MemcachedClient memcachedClient = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        builder = new XMemcachedClientBuilder(
                AddrUtil.getAddresses(environment.getProperty("memcached.host")));
    }

    public MemcachedClient getMemcachedClient() {
        if (memcachedClient == null) {
            try {
                LOCK.lock();
                if (memcachedClient == null) {
                    builder.setConnectionPoolSize(99);
                    memcachedClient = builder.build();
                }
            } catch (IOException e) {
                LOGGER.error("连接memcatch服务器异常！", e);
                return null;
            } finally {
                LOCK.unlock();
            }
        }
        return memcachedClient;
    }

    public void saveToCache(String key, Object value) {
        LOGGER.debug("saveToCache(key:{},value{})", key, value);
        try {
            getMemcachedClient().set(key, 0, value);
        } catch (Exception e) {
            LOGGER.error("缓存数据错误", e);
        }
    }

    public void saveToCache(String key, int exp, Object value) {
        LOGGER.debug("saveToCache(key:{},value{})", key, value);
        try {
            getMemcachedClient().set(key, exp, value);
        } catch (Exception e) {
            LOGGER.error("缓存数据错误",e);
        }
    }

    public <T> T getFromCache(String key) {
        LOGGER.debug("getFromCache(key:{})", key);
        try {
            return getMemcachedClient().get(key);
        } catch (Exception e) {
            LOGGER.error("获取缓存错误", e);
        }
        return null;
    }

    public boolean removeFromCache(String key) {
        LOGGER.debug("removeFromCache(key:{})", key);
        try {
            return getMemcachedClient().delete(key);
        } catch (Exception e) {
            LOGGER.error("删除缓存错误", e);
        }
        return false;
    }
}
