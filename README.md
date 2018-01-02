#接口列表和优先级:
##一、登陆 注册    p0

##二、商品展示
a.首页商品列表   p0
b.获取商品分类，各分类下商品列表 p1  
c.商品搜索      p1
d.商品详情展示    p0


##三、下单和订单管理
a.下单               p0（暂时不做支付）
b.订单查看          p0


## ERROR 集合

执行Application，并访问 http://localhost:9199/sale/index

> 初始化构建项目方式，两种

一种是IDE
一种是构建网站

> 链接mysql报错

```$xslt
Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
```

* 在mysql连接字符串url中加入ssl=true或者false即可，如下所示。
  　　url=jdbc:mysql://127.0.0.1:3306/framework?characterEncoding=utf8&useSSL=true
  
> session 配置错误

```$xslt

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$SessionRepositoryValidator': Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: No Spring Session store is configured: set the 'spring.session.store-type' property
```

在网上搜索之后，发现session store type使用来存放session的存储方式，目前Spring boot中只支持Redis方式。 由于本应用暂无需将session放入redis的需求，故这里就可以将session store type设置为none.

 这里我们将此配置信息放入application.properites之中：

#### default-store in spring session. it will be set in redis only outside.

spring.session.store-type=none

再次启动，成功。

如果使用redis存储session:

application.properties配置

spring.session.store-type=redis
加入redis配置：

```
spring.redis.database=0
spring.redis.host=localhost
spring.redis.password=
spring.redis.pool.max-active=8
spring.redis.pool.max-idle=8
spring.redis.pool.max-wait=-1
spring.redis.pool.min-idle=0
spring.redis.port=6379
```



##包介绍

### Lombok

Lombok想要解决了的是在我们实体Bean中大量的Getter/Setter方法，以及toString, hashCode等可能不会用到，但是某些时候仍然需要复写，以期方便使用的方法；在使用Lombok之后，将由其来自动帮你实现代码生成，注意，其是在运行过程中，帮你自动生成的。就是说，将极大减少你的代码总量。

> [使用方式](http://blog.csdn.net/blueheart20/article/details/52909775)

### mysql-connector-java

> [使用方式](http://blog.csdn.net/catoop/article/details/50507516)


### commons-io

> [使用方式](http://blog.csdn.net/tiantang_1986/article/details/51034401)

### commons-net

Apache commons net 项目中封装了各种网络协议的客户端

> [使用方式](http://blog.csdn.net/ffm83/article/details/42144363)

### joda-time

Joda-Time 令时间和日期值变得易于管理、操作和理解。事实上，易于使用是 Joda 的主要设计目标。其他目标包括可扩展性、完整的特性集以及对多种日历系统的支持。
> [使用方式](https://www.ibm.com/developerworks/cn/java/j-jodatime.html)


### springfox-swagger2

可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档
> [使用方式](https://www.cnblogs.com/xiaohanghang/p/6018654.html)

### commons-beanutils

可以很方便的对bean对象的属性进行操作。今天为大家介绍一下该包的常用方法。
> [使用方式](http://blog.csdn.net/jianggujin/article/details/51104949)
