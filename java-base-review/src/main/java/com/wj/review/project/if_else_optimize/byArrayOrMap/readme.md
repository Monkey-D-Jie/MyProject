[本实践demo原文链接](https://www.cnblogs.com/edda/p/14787456.html)

### 1.业务需求

一个简单分享的业务需求：支持分享链接、图片、文本和图文，分享结果回调给用户（为了不跑题，这里简略了业务，实际复杂得多）。

### 2.传统的需求解决方案

根据业务需求来，直接借助if-else的判断即可实现。

参见目录【byArrayOrMap.original】下方的demo样例代码。

参见[OriginalShareService]的实现可知，虽然伪代码实现了功能需求，但从整体上来看，是不易读，且缺乏扩展性的。

### 3.优化后的解决方案

从[OriginalShareService]实现方法来剖析，让其if-else存在过多的主要因素可归结如下。

* 空值判断
* 状态判断
* 业务判断

因此，就该段代码的if-else优化也主要将围绕以下几点展开。

* 接口分层
* 多态
* 使用map替代分支语句

#### 1）接口分层

将接口从逻辑上分为外部接口和内部接口。外部接口主要是保证内部接口的入参合法。而内部接口则作为主方法介入的一个引子。

#### 2）多态

针对各分享类，抽象其统一行为，完成各分享类的‘多态’实现。这样的好处就是，传入对象的时候，就能直接定位到对应的分享类，自然也就能避免if-else的判断操作了。

#### 3）使用map替代分支语句

这块儿主要是针对方法作为第三方的SDK时的情况。相比于让调用方多添加几个实体类，让对方多调用几个方法可能是更优雅的接口给出方式。

