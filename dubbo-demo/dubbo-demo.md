# dubbo-demo 学习练成记

本文档的目的旨在记录demo搭建过程中参考的帖子和遇到的问题心得。

### 1.demo搭建参考帖子

#### ~~1.1 from博客园~~
*[Dubbo的Hello World](https://www.cnblogs.com/java-chen-hao/p/9681767.html)

上面的这篇帖子，不太行。虽然记录的还算详实，但代码里残缺的地方太多了。着实给学习不来。

#### 1.2 from 思否平台

还是来看看Guide哥的帖子吧，看起都要更舒服些。

*[Dubbo Hello World ——Guide哥](https://segmentfault.com/a/1190000017178722?utm_source=sf-similar-article)

####1.2.1 项目启动依赖报错

笔者遇到的问题，按照帖子中的说明，完成了整体demo的搭建后。

在正常开启了zk的情况下，启动provider/consumer，都是打印了启动日志，
然后直接就Terminate掉了。后来，经过网络上的一番搜索，才找到了下方链接的解决方法。


不加这个依赖，provider启动后，直接不报错的被Terminated了。
问题解决参考链接来自： [Dubbo成功启动的秘诀](http://121.196.162.47/archives/z-k--d-u-b-b-o)

`
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
</dependency>
`


### 2.面试中可能出现的问题

* [Dubbo九连问，值得你细读一番](https://mp.weixin.qq.com/s/wM0Vj_YMh7881NwK-AwKSw)


 

