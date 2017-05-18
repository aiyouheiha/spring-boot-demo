###### heiha ######

# Spring Boot Demo

--------------------------------------------------------------

> Some using samples for Spring Boot.

--------------------------------------------------------------

- [sample-properties]()
- [sample-redis]()
- [sample-aop]()
- [sample-mysql-mybatis]()
- [sample-zk]()
    - [关于Curator分布式锁“无法生效”的问题](http://blog.csdn.net/szj9106/article/details/72393764)
- [exclusive-editor](#exclusive-editor)

--------------------------------------------------------------

[TOP](#heiha)

## exclusive-editor

**Exclusive Editor**

Exclusive editor is actually a type of lock set. It is distributed, having multi locks, and lock will be acquired by giving holder exclusive.

Lock is NON re-entrant, once lock, following acquires failed until lock release.

--------------------------------------------------------------
