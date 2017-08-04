package com.heiha.example.springboot.memcached;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 11:09<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "memcached", name = "address")
@ConfigurationProperties("memcached")
public class MemcachedProperties {
    private String address = "localhost:11211";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
