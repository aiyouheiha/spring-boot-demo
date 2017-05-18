package com.heiha.example.memcached;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 11:09<br>
 * <b>Author:</b> heiha<br>
 */
@ConfigurationProperties("memcached")
public class MemcachedProperties {
    private String host = "localhost:11211";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
