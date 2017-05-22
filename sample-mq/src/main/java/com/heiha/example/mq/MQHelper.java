package com.heiha.example.mq;

import com.sun.jndi.ldap.pool.PooledConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/17 18:51<br>
 * <b>Author:</b> heiha<br>
 *
 * @see org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties
 * @see org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration
 */
@Component
public class MQHelper {
    @Autowired
    private ActiveMQProperties properties;

    @Bean("jmsFactory")
    public PooledConnectionFactory pooledConnectionFactory(@Qualifier("activeMQConnectionFactory") ActiveMQConnectionFactory activeMQConnectionFactory) {
        return null;
    }

    @Bean("activeMQConnectionFactory")
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(properties.getBrokerUrl());
        factory.setMaxThreadPoolSize(100);
        return factory;
    }

    @Bean
    public ActiveMQQueue activeMQQueue() {
        return new ActiveMQQueue("sample.queue");
    }

}
