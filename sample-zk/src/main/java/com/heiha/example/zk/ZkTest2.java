package com.heiha.example.zk;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/8 10:13<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class ZkTest2 {
    private ZkHelper zkHelper;
    private InterProcessMutex lockInner;
    @Autowired
    private ZkTest zkTest;

    @Autowired
    public ZkTest2(ZkHelper zkHelper) {
        this.zkHelper = zkHelper;
        this.lockInner = new InterProcessMutex(zkHelper.getClient(), "/lockInner");
    }

    public void use() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName().concat(" 2 acquire lock"));
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" 2 acquire lock ok"));
            System.out.println(Thread.currentThread().getName().concat(" 2 acquire lock"));
            lockInner.acquire();
            System.out.println(Thread.currentThread().getName().concat(" 2 acquire lock ok"));
            lockInner.release();
            System.out.println(Thread.currentThread().getName().concat(" 2 release lock inner"));

            System.out.println(Thread.currentThread().getName().concat(" 2 test start"));
            zkTest.use();
            System.out.println(Thread.currentThread().getName().concat(" 2 test ok"));
        } finally {
            lockInner.release();
            System.out.println(Thread.currentThread().getName().concat(" 2 release lock"));
        }
    }

}
