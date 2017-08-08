package com.heiha.example.zk;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/8 10:09<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class ZkTest {
    private ZkHelper zkHelper;
    private InterProcessMutex lockInner;

    @Autowired
    public ZkTest(ZkHelper zkHelper) {
        this.zkHelper = zkHelper;
        this.lockInner = new InterProcessMutex(zkHelper.getClient(), "/lockInner");
    }

    public void use() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName().concat(" get lock"));
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" get lock ok"));
        } finally {
            lockInner.release();
            System.out.println(Thread.currentThread().getName().concat(" release lock"));
        }
    }
}
