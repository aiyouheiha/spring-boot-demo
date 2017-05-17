package com.heiha.example.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/12 17:02<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class ZkHelper implements InitializingBean {
    @Autowired
    private ZookeeperProperties properties;

    private  CuratorFramework client;

    private InterProcessMutex lock;

    public void use() throws Exception {
        lock.acquire();
        lock.acquire();
        lock.release();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(properties.getConnectString())
                .retryPolicy(retryPolicy)
                .namespace("topology")
                .build();
        client.start();
        lock = new InterProcessMutex(client, "/lock");
    }

    private void sleep() {
        try {
            Thread.sleep(300 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
