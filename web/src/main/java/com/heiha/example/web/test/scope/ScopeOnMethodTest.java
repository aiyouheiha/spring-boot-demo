package com.heiha.example.web.test.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/17 10:47<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class ScopeOnMethodTest {
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean("userSingleton")
    public User getUserSingleton() {
        return new User();
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean("userPrototype")
    public User getUserPrototype() {
        return new User();
    }

    public static class User {
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
