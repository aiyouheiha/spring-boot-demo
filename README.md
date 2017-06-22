###### heiha ######

# Spring Boot Demo

> 一个充斥着蹩脚英语的 Spring Boot Demo

--------------------------------------------------------------

- [web](#web)
    - [web-demo-1 仅对特定Controller方法添加特定响应头](#web-demo-1)
- [sample-zk](#sample-zk)
    - [关于Curator分布式锁“无法生效”的问题](http://blog.csdn.net/szj9106/article/details/72393764)

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

[TOP](#heiha)

--------------------------------------------------------------

## sample-zk

### 关于Curator分布式锁“无法生效”的问题

- [关于Curator分布式锁“无法生效”的问题](http://blog.csdn.net/szj9106/article/details/72393764)

[TOP](#heiha)

--------------------------------------------------------------




