# Spring Cloud Seata实践操作记录

> 本实践项目，笔者还是以“不才”老师的帖子作为主线。
> 
> [更偏爱阿里开源的Seata，真香！(原理+实战)](https://mp.weixin.qq.com/s?__biz=MzU3MDAzNDg1MA==&mid=2247499421&idx=1&sn=a55797652284bafd9216ea981f4125e0&chksm=fcf72150cb80a846e62beecc2a9f1e251bcd0e23136175504a7e28f1cce2ff5f5a26da1960a2&cur_album_id=2042874937312346114&scene=190#rd)

2023年8月14日14:26:11 更新

因为本在仓储服务中会用涉及数据库查询的相关操作。索性，在此处就直接引入mybatis-plus来做相应的
处理。正好可以熟悉mybatis-plus的一些使用方法。

> 参考帖子：[Springboot整合mybatis-plus](https://blog.csdn.net/weixin_44162337/article/details/107828366)

2023年8月21日15:41:32 更新

中间中断了些时间。现在又重新将其抓起来。storage，order，account三个模块的基本代码
写完后，启动storage模块，上来就遇到了一个问题。

> NoClassFoundException,类找不到的异常/springframework/core/metrics/ApplicationStartup

经过一番搜索，搜索结果给到的说明为

`这个错误通常是由于您在应用程序的依赖中没有包含 Spring Boot Actuator 依赖导致的。Actuator 是 Spring Boot 中一个用于监控和管理应用程序的模块。`

引入以下依赖即可（因为笔者的父工程中已经有springboot相关依赖的版本声明了，
故此处就可以不用指明版本了）

```
<dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

但是上面的配置我加到自己的pom文件中后，发现并没有起到我想要的效果。

综合下来，出现上面的问题一般的解决方案主要是两种。

> 第一种

子工程的springboot依赖版本要比父版本的高，这个时候，根据实际的版本情况做调整即可。

> 第二种

就是前面提到的新增“actuator”依赖，然后再看看效果。

> 第三种

这种处理方案来自
[Spring Boot ClassNotFoundException org.springframework.core.metrics.ApplicationStartup](https://stackoverflow.com/questions/65046056/spring-boot-classnotfoundexception-org-springframework-core-metrics-applications)

```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>2.3.3.RELEASE</version>
</dependency>
```

