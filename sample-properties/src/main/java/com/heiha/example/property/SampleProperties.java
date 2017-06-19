package com.heiha.example.property;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/9 10:33<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "sample", name = "host")
@ConfigurationProperties(prefix = "sample")
public class SampleProperties {
    private String host = "localhost";
    private int port;
    private String password;
    private Pool pool;
    private Map<String, Integer> testMap = new HashMap<>();

    public Map<String, Integer> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<String, Integer> testMap) {
        this.testMap = testMap;
    }

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

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public static class Pool {
        private int maxActive = 0;
        private int maxIdle = 0;

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
}
