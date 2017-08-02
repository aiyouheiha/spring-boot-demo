package com.heiha.example.springboot.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/2 11:42<br>
 * <b>Author:</b> heiha<br>
 */
@ConfigurationProperties(prefix = "demo.web.security")
public class WebSecurityProperties {
    private String user = "admin";
    private String password = "123456";
    private String role = "USER";

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
