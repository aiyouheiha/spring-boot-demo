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

    private InterProcessMutex lockInner;

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
        // [错误]~~并不需要统一的使[错误]用一个lock对象，只要路径相同[错误]，便是使用同一个锁~~[错误]
        // 处理同一个业务，即使路径相同，也要使用同一个锁对象！！！
        // 否则，容易出现，业务阶段一申请到锁，未释放，业务阶段二申请锁
        // 此时，即使路径相同，但因为不是同一个锁对象，将会造成死锁！！！！
        // 最佳方式是只对应一个锁，这样保证同一业务（线程）可重入，而不同线程，则会等待持有锁业务释放锁
        lockInner = new InterProcessMutex(client, "/lockInner");
    }

    public InterProcessMutex getLock() {
        return lockInner;
    }

    public CuratorFramework getClient() {
        return client;
    }

    public void use(String path, String data) throws Exception {
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName().concat(" get lock"));
                lockInner.acquire();
                System.out.println(Thread.currentThread().getName().concat(" get lock"));
                Thread.sleep(10000);
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

        try {
            System.out.println(Thread.currentThread().getName().concat(" get lock"));
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" get lock"));
            Thread.sleep(10000);
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
    }

    private void printObject(Object o) {
        System.out.println(JSON.toJSONString(o));
    }
}

