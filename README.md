# Spring Boot Demo

--------------------------------------------------------------

- [test](#test)
- [Spring Boot ActiveMQ](#Spring Boot ActiveMQ)

--------------------------------------------------------------

## Spring Boot ActiveMQ

### 1. Download ActiveMQ

Download from: http://activemq.apache.org/download.html

### 2. Run ActiveMQ

- Windows
    - Unzip download
    - Run `apache-activemq-5.14.5/bin/win64/activemq.bat` or `apache-activemq-5.14.5/bin/win32/activemq.bat`
    - Visit http://localhost:8161/
    - Click `Manage ActiveMQ broker` and access with default `admin/admin`

### 3. Dependencies

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-activemq</artifactId>
</dependency>
```

### 4. application.yml

```
spring:
  activemq:
    broker-url: tcp://localhost:61616
    user: system
    password: manager
```

> About user and password: Go to `apache-activemq-5.14.5/conf`, see `activemq.xml` and `credentials.properties`

### 5. Producer

```
package com.heiha.example.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/22 18:34<br>
 * <b>Author:</b> heiha<br>
 */
@Service
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
```

### 6. Consumer

```
package com.heiha.example.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/22 18:38<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class Consumer {
    @JmsListener(destination = "heiha.test.queue")
    public void receive(String text) {
        System.out.println(Thread.currentThread().getName().concat(" - Consumer - ") + text);
    }
}
```

### 7. Test

```
package com.heiha.example.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMqApplication.class)
public class SampleMqApplicationTests {
	@Autowired
	private Producer producer;

	@Test
	public void test() {
		Destination destination = new ActiveMQQueue("heiha.test.queue");
		for (int i = 0; i < 30; i++) {
			producer.send(destination, "Text - " + i);
		}
	}
}
/*
    DefaultMessageListenerContainer-1 - Consumer - Text - 0
    DefaultMessageListenerContainer-1 - Consumer2 - Text - 1
    DefaultMessageListenerContainer-1 - Consumer - Text - 2
    DefaultMessageListenerContainer-1 - Consumer2 - Text - 3
    DefaultMessageListenerContainer-1 - Consumer - Text - 4
    DefaultMessageListenerContainer-1 - Consumer2 - Text - 5
    ...
*/
```



--------------------------------------------------------------

## web

### web-demo-1

> 仅对特定Controller方法添加特定响应头

- 描述
    - 通过自定义注解，在特定Controller方法处调用切面方法
    - 在切面方法中使用Filter、Interceptor、或者RequestContextHolder中持有的当前线程response对象
    - 使用当前线程的response对象，添加特定响应头

- 相关模块
    - web
        - ResponseHeaderAddTestController
    - sample-aop
        - ResponseHeaderAddTest
        - ResponseGetMethod
        - ResponseHeaderAddTestAspect
    - sample-common
        - ResponseHolderFilter
        - ResponseHolderInterceptor
        - ResponseHolderInterceptorAdapter
    
- 关键词
    - Aspect
    - 获取当前请求的响应对象
        - Interceptor
        - Filter
        - RequestContextHolder
        
- tip
    - RequestContextHolder获取response在Spring3没有提供支持
    - 当然可以通过Controller方法直接获取的response对象来添加
        - 不这样做，是应为这必然需要较高程度的修改原Controller类
        - 而使用切面的方式，只需要在对应方法处添加注解即可

- 声明
    - 并不知道该方法的好坏，出事情概不负责
    - 顺便求指点，如果有人看到的话

--------------------------------------------------------------

## sample-zk

### 关于Curator分布式锁“无法生效”的问题

- [关于Curator分布式锁“无法生效”的问题](http://blog.csdn.net/szj9106/article/details/72393764)

--------------------------------------------------------------




