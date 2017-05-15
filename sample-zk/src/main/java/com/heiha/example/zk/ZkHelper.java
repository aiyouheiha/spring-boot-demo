package com.heiha.example.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
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

    private InterProcessSemaphoreMutex lock;

    public void use() throws Exception {
        lock.acquire();
        System.out.println(properties.getConnectString());
        System.out.println(properties.isEnable());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(properties.getConnectString(), retryPolicy);
        client.start();
        if (client.checkExists().forPath("/topology") == null) {
            client.create().forPath("/topology");
        }
        lock = new InterProcessSemaphoreMutex(client, "/topology/test-lock");
    }
}
