package com.heiha.example.zk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-05-15 01:36
 * <b>Author:</b> heiha
 */
@Component
public class ZookeeperProperties {
    @Value("${spring.cloud.zookeeper.enabled}")
    private boolean enable;

    @Value("${spring.cloud.zookeeper.connect-string}")
    private String connectString;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }
}
