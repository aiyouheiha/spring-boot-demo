package com.heiha.example.zk;

import com.alibaba.fastjson.JSON;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(properties.getConnectString())
                .retryPolicy(retryPolicy)
                .namespace(properties.getNamespace())
                .build();
        client.start();
        // 锁可重入
        // 锁acquire多少次，就必须release多少次，而不是一次顶多次
        // 并不需要统一的使用一个lock对象，只要路径相同，便是使用同一个锁
        lock = new InterProcessMutex(client, "/lock");
    }

    public void use(String path, String data) throws Exception {
        new Thread(() -> {
            InterProcessMutex lockInner = new InterProcessMutex(client, "/lockInner");
            try {
                lockInner.acquire();
                System.out.println(Thread.currentThread().getName().concat(" get lock"));
                lockInner.acquire();
                System.out.println(Thread.currentThread().getName().concat(" get lock again"));
                Thread.sleep(10000);
                lockInner.release();
                System.out.println(Thread.currentThread().getName().concat(" release lock"));
                Thread.sleep(5000);
                lockInner.acquire();
                System.out.println(Thread.currentThread().getName().concat(" get lock 2"));
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lockInner.release();
                    System.out.println(Thread.currentThread().getName().concat(" release lock"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        InterProcessMutex lockInner = new InterProcessMutex(client, "/lockInner");
        try {
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" get lock"));
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" get lock again"));
            Thread.sleep(10000);
            lockInner.release();
            System.out.println(Thread.currentThread().getName().concat(" release lock"));
            Thread.sleep(5000);
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" get lock 2"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lockInner.release();
                System.out.println(Thread.currentThread().getName().concat(" release lock"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // check exist
        Stat stat = client.checkExists().forPath(path);
        System.out.println("Current status -");
        printObject(stat);

        if (stat == null) {
            String createReturn = client.create().forPath(path, data.getBytes());
            System.out.println("No path and create, create return is -");
            printObject(createReturn);
        } else {
            String oldData = new String(client.getData().forPath(path));
            System.out.println("Having path and get data -");
            printObject(oldData);
            Stat statSet = client.setData().forPath(path, data.getBytes());
            System.out.println("Set new data -");
            printObject(statSet);
        }

        System.out.println("Current data in path -");
        printObject(new String(client.getData().forPath(path)));

        printObject("Delete and recheck exists -");
        client.delete().forPath(path);
        printObject(client.checkExists().forPath(path));
    }

    private void printObject(Object o) {
        System.out.println(JSON.toJSONString(o));
    }

    private class UseThread implements Runnable {

        @Override
        public void run() {

        }
    }
}

