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
    @Value("${zk.connect-string}")
    private String connectString;

    @Value("${zk.namespace}")
    private String namespace;

    public String getConnectString() {
        return connectString;
    }

    public void setConnectString(String connectString) {
        this.connectString = connectString;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
