## Java事务常见要点摘录

***2024年2月28日09:34:29更新***

> 参考链接
> [Spring事务面试考点](https://www.cnblogs.com/lixinjie/p/spring-tx-key-point-in-a-interview.html)
> [Spring事务的配置、参数详情及其原理介绍(Transactional) - kosamino - 博客园](https://www.cnblogs.com/jing99/p/11495252.html)
> [Spring 事务详解 | JavaGuide](https://javaguide.cn/system-design/framework/spring/spring-transaction.html#%E5%8F%82%E8%80%83)
> [太难了~面试官让我结合案例讲讲自己对Spring事务传播行为的理解](https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247486668&idx=2&sn=0381e8c836442f46bdc5367170234abb&chksm=cea24307f9d5ca11c96943b3ccfa1fc70dc97dd87d9c540388581f8fe6d805ff548dff5f6b5b&token=1776990505&lang=zh_CN#rd)

### 1.Spring和事务的关系

关系型数据库，某些消息队列（RocketMQ，RabbitMQ，Kafka等）或者一些中间件（比如大名鼎鼎的seata）等***事务性资源***，它们本身支持事务，也能处理事务。

但Spring不是事务性资源。从日常的开发中，我们可以得出结论：Spring管理事务性资源的一种方法。所以，Spring和事务之间是一个管理关系，而不是包好关系。

### 2.Spring事务的三要素

* 数据源：表示具体的事务性资源，事务相关操作的真正执行者，如MySQL等。
* 事务管理器：从整体上管理事务的处理过程，如打开，提交，回滚等。
* 事务应用和属性配置：用以标识哪些地方需要参与事务，如何参与事务（比如设置事务的隔离级别、传播级别，超时时间等）

#### 2.1 引申：事务的4大特性

* 原子性：要么全部成功，要么都失败。
* 持久性：修改动作产生的结果将被持久化存储。
* 隔离性：多个事务并发执行时，某一个具体事务的操作不影响其他事务的操作。
* 一致性：数据写入前和写入后，数据间本身的约束关系不会被破坏。

### 3.Spring事务的注解配置方式

* 在Spring中设置事务的常规方法
  
  ①：把一个DataSource（如DruidDataSource）作为一个@Bean注册到Spring容器中，配置好事务性资源。
  ![事务性资源对象](assets/通过Bean指定一个事务性资源对象.png?t=1709098355842)
  
  ②：把一个@EnableTransactionManagement注解放到一个@Configuration类上，配置好事务管理器，并启用事务管理。
  
  **注意：需要确保你是成功地启动了注解驱动的事务管理才行。**
  
  ![事务管理声明](assets/事务1-事务管理声明.png)
  
  ③：把一个@Transactional注解放到类上或方法上，可以设置注解的属性，表明该方法按配置好的属性参与到事务中。
  
  ![事务注解声明](assets/事务1-事务注解声明.png?t=1709098700397)
* **在Spring中设置事务的常规方法**
  
  前面的几幅图描述的即是在Spring中声明事务的常见配置方法。
* **在Springboot中设置事务的常规方法**
  
  在使用@Transactional的方法上,两者基本上是一致的。所不同的只是，Springboot已经自动的帮开发者完成了部分配置。开发者只需要结合自己的需求来加以补充即可。
  
  数据源的配置部分，直接通过pom依赖即可以完成。无需再到代码中去指定‘事务性资源’的bean对象。
  
  ![springboot1.png](assets/springboot-事务1-事务注解声明.png?t=1709099226617)
  
  ![1.png](assets/事务1-事务管理声明.png?t=1709099385779)
* **两者的区别**

从前面的贴图可知，两者的主要不同在于‘事务性资源’和‘事务管理声明’两块儿有所不同。在实际的应用上基本上都是一致的。

#### 3.1 @Transactional事务注解在类/方法上

表示对应的类/方法将参与到事务中去。当类上和方法上都有事务注解时，方法上的优先级更高（从颗粒度粗细的角度来讲也是如此，方法层面是更细的范畴）。

#### 3.2 @Transactional事务注解在类上的继承性

标记在父类上的注解可以传播到其子类中。也就是说，父类如果标注了事务注解，则其子类也将参与到事务中去。反过来就不行了。

#### 3.3 @Transactional事务注解在接口/类上

一般来说，都不标记在接口上的。官方也建议将事务注解标注在类或者方法上，而非接口上。**在接口上时，必须使用基于接口的代理才行，即JDK动态代理（日常使用中可以忽略这种情况）。**

### 4.事务注解的本质

主要是针对@Transactional这个注解来说的。有它在的地方，表名其标记的方法或者类将会参与到事务中去。另一方面，也可以通过其可以设置的属性，进一步细颗粒度的控制事务的作用范围和实际效果（大多数情况下，只用默认的也就足够了）。

### 5.Spring事务的常见分型

**Spring 事务管理**分为编程式和声明式的两种方式。编程式事务指的是通过编码方式实现事务；声明式事务基于 AOP,将具体业务逻辑与事务处理解耦。声明式事务管理使业务代码逻辑不受污染, 因此在实际使用中声明式事务用的比较多。

![编程式事务和声明式事务](assets/编程式事务和声明式事务.png?t=1709100557014)

#### 5.1 ★编程式事务

通过 `TransactionTemplate`或者`TransactionManager`手动管理事务。但在实际应用中用的比较少，因为它具有一定的代码侵入性。

①：使用`TransactionTemplate` 进行编程式事务管理的示例代码如下

```
@Autowired
private TransactionTemplate transactionTemplate;
public void testTransaction() {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

                try {

                    // ....  业务代码
                } catch (Exception e){
                    //回滚
                    transactionStatus.setRollbackOnly();
                }

            }
        });
}
```

②：使用 `TransactionManager` 进行编程式事务管理的示例代码如下

```
@Autowired
private PlatformTransactionManager transactionManager;

public void testTransaction() {

  TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
          try {
               // ....  业务代码
              transactionManager.commit(status);
          } catch (Exception e) {
              transactionManager.rollback(status);
          }
}
```

#### 5.2 ★声明式事务

推荐使用（代码侵入性最小），实际是通过 AOP 实现（基于`@Transactional` 的全注解方式使用最多）。

使用 `@Transactional`注解进行事务管理的示例代码如下

```
@Transactional(propagation = Propagation.REQUIRED)
public void aMethod {
  //do something
  B b = new B();
  C c = new C();
  b.bMethod();
  c.cMethod();
}
```

### 6.事务生效

#### 6.1 只在public方法上生效？

当采用代理来实现事务时，（注意是代理），`@Transactional`注解只能应用在public方法上。当标记在`protected`、`private`、`package-visible`方法上时，不会产生错误，但也不会表现出为它指定的事务配置。可以认为它作为一个普通的方法参与到一个`public`方法的事务中。

如果想在非public方法上生效，考虑使用AspectJ（织入方式,就是借助AOP在PointCut上用通配符的形式指定方法）.

#### 6.2 目标类里的自我调用没有事务？

在代理模式中（这是默认的），只有从外部的方法调用进入通过代理会被拦截，这意味着自我调用（实际就是，目标对象中的一个方法调用目标对象的另一个方法）在运行时不会导致一个实际的事务，即使被调用的方法标有注解。

如果你希望自我调用也使用事务来包装，考虑使用AspectJ的方式。在这种情况下，首先是没有代理。相反，目标类被织入（即它的字节码被修改）来把`@Transactional`加入到运行时行为，在任何种类的方法上都可以。

### 7.回滚事务

#### 7.1 如何回滚一个事务

在一个事务的上下文中当前正执行的代码抛出异常，事务基础设施的代码会捕捉任何未处理的异常。并根据事务注解的声明来确定是否要执行回滚操作。

#### 7.2 默认回滚规则

默认只把runtime, unchecked exceptions标记为回滚，即RuntimeException及其子类，Error默认也导致回滚。Checked exceptions默认不导致回滚。

【
注：Checked exceptions。就是在编译过程中出现的那些异常
![.png](assets/编译期异常.png?t=1709101605631)
】

#### 7.3 如何配置回滚异常

使用`@Transactional`注解的`rollbackFor/rollbackForClassName`属性，可以精确配置导致回滚的异常类型，包括checked exceptions。

`noRollbackFor/noRollbackForClassName`属性，可以配置不导致回滚的异常类型，当遇到这样的未处理异常时，照样提交相关事务

### 8.事务与线程以及事务的属性

和JavaEE事务上下文一样，Spring事务和一个线程的执行相关联，底层是一个ThreadLocal<Map<Object, Object>>，就是每个线程一个map，key是DataSource，value是Connection。

事务的属性包含哪些呢？

* 传播特性
* 隔离级别
* 回滚规则
* 是否只读
* 事务超时

#### 8.1 逻辑事务与物理事务

物理事务就是事务性自研打开的事务，比如MySQL连接中打开的一个事务就是物理事务。

标注了@Transactional注解后，Spring会为它们分配一个事务范围，这个事务范围就是逻辑事务。

在逻辑事务中，大范围的事务叫外围事务，小范围的事务被称作内部事务。外围事务可以包含内部事务。但在逻辑上又是独立的。

那么如何处理`逻辑事务和物理事务之间的关联关系`呢，这就是传播特性解决的问题。

#### 8.2 事务的传播特性

REQUIRED，SUPPORTS，MANDATORY，REQUIRES_NEW，NOT_SUPPORTED，NEVER，NESTED

> 重点参考链接
> [Spring 事务详解 | JavaGuide](https://javaguide.cn/system-design/framework/spring/spring-transaction.html#%E4%BA%8B%E5%8A%A1%E5%B1%9E%E6%80%A7%E8%AF%A6%E8%A7%A3)
> [太难了~面试官让我结合案例讲讲自己对Spring事务传播行为的理解。](https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247486668&idx=2&sn=0381e8c836442f46bdc5367170234abb&chksm=cea24307f9d5ca11c96943b3ccfa1fc70dc97dd87d9c540388581f8fe6d805ff548dff5f6b5b&token=1776990505&lang=zh_CN#rd)

##### 8.2.1 Propagation.REQUIRED

使用的最多的一个事务传播行为，我们平时经常使用的`@Transactional`注解默认使用就是这个事务传播行为。如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。也就是说：

* 如果外部方法没有开启事务的话，`Propagation.REQUIRED`修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰。
* 如果外部方法开启事务并且被`Propagation.REQUIRED`的话，所有`Propagation.REQUIRED`修饰的内部方法和外部方法均属于同一事务 ，只要一个方法回滚，整个事务均回滚。
 

##### 8.2.2 Propagation.REQUIRES_NEW

创建一个新的事务，如果当前存在事务，则把当前事务挂起。也就是说不管外部方法是否开启事务，`Propagation.REQUIRES_NEW`修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰。

##### 8.2.3 Propagation.NESTED

如果当前存在事务，就在嵌套事务内执行；如果当前没有事务，就执行与`TransactionDefinition.PROPAGATION_REQUIRED`类似的操作。也就是说：

* 在外部方法开启事务的情况下，在内部开启一个新的事务，作为嵌套事务存在。
* 如果外部方法无事务，则单独开启一个事务，与 `PROPAGATION_REQUIRED` 类似。

##### 8.2.4 Propagation.MANDATORY(用的比较少)

如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。（mandatory：强制性）

##### 8.2.5 Propagation.SUPPORTS(用的比较少)

如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。

##### 8.2.6 Propagation.NOT_SUPPORTED(用的比较少)

以非事务方式运行，如果当前存在事务，则把当前事务挂起。

##### 8.2.7 Propagation.NEVER(用的比较少)

以非事务方式运行，如果当前存在事务，则抛出异常。

#### 8.3 事务的隔离级别

##### 8.3.1 常见的几种错读方式

* 脏读
* 幻读
* 不可重复读

##### 8.3.2 不同事务隔离级别的作用

* DEFAULT
* READ_UNCOMMITTED
* READ_COMMITTED
* REPEATABLE_READ
* SERIALIZABLE

