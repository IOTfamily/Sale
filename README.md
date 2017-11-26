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