package com.heiha.example.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/10 17:10<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "sample", name = "host")
@Component
public class SampleProperties2 {
    @Value("${sample.host}")
    private String host = "localhost";

    @Value("${sample.port}")
    private int port;

    @Value("${sample.password}")
    private String password;

    @Value("${sample.pool.max-active}")
    private int maxActive = 0;

    @Value("${sample.pool.max-idle}")
    private int maxIdle = 0;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }
}
