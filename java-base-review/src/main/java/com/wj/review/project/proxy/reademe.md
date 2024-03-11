# Java 静态代理和动态代理

> 参考链接：[Java代理模式详解](https://javaguide.cn/java/basis/proxy.html)

## 1.引言

在日常的开发中，我们很少会显式的用到代理模式。但是它们却普遍存在于Spring的框架中。

典型的比如Spring的AOP，就是基于了一种代理对象的原理来执行到的。

从字面意思来说，代理模式的重点在于‘代理’。它们就像我们日常生活中去办证中心时，面对的

中心工作人员一样。

被赋予可以给我们办证的权利，但在其背后，是办证中心的对应的中央机构直辖。

这种方式的好处显而易见：让不同的角色着重于不同的流程，从而能让整体的流程效率提高。

即能丰富被代理对象的功能，毕竟让做决策的人去做一些重复流程的活儿，显然是一种资源应用的不合理嘛。

回到正题，代码模式分为两种。

* 静态代理
* 动态代理

## 2.静态代理

### 2.1 静态代理简述

代理的做作用是对被代理对象做一系列的增强操作，以更方便我们的实际应用和操作。

从实现角度来说，静态代理对方法的增强依赖于手动的实现，这种方式带来的一个弊端就是不灵活。比如你要增加一个增强方法，就需要把涉及到的类全都做一个更改，相当于重复初步增强的每一个步骤了。

另外一方面，手动实现的方法，虽然能保证在构建代理方法整体过程的稳定性，但这样又会产生一种‘无端的浪费’——即不管你是否会用到，静态代理创建过程中涉及的接口类，实现类，代理类都将在编译期即生成相应的class字节码文件。

### 2.2 静态代理的实现步骤

> 1）定义一个接口及其实现类

```
//1)定义发送短信的接口
public interface SmsService {
    String send(String message);
}
```

> 2）创建一个代理类，同样实现这个接口

```
//2) 实现发送短信的接口
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
```

> 3）将目标对象注入代理类，并在调用代理类中的代理方法时，调用目标对象中对应的代理方法

```
//3)创建代理类，并实现发送短信的接口
public class SmsProxy implements SmsService {
    //注入 目标对象
    private final SmsService jdkSmsService;

    public SmsProxy(SmsService jdkSmsService) {
        this.jdkSmsService = jdkSmsService;
    }
    //通过实现接口方法，完成代理，外部调用方法，最终会作用到目标对象中。在实现了方法调用的同时，还做一些其他的增强（日志打印）操作
    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        jdkSmsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
```

> 4）实际使用

```
public class Main {
    public static void main(String[] args) {
        SmsService jdkSmsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(jdkSmsService);
        smsProxy.send("java");
    }
}

//输出结果
before method send()
send message:java
after method send()
```

## 3.动态代理

### 3.1 动态代理简述

动态代理不用那么死板的依赖接口实现，是一种可以按需加载的代理方法。

从JVM层面来说，动态代理是在运行时生成相应的字节码，然后加载进JVM中的。

（Spring Aop和RPC框架的实现都是依赖于动态代理）

动态代理虽然在开发中实际应用的少，但是我们使用的框架里却常能看见他们的影子。

动态代理的实现方式有多重，比较常见的就是JDK动态代理和CGLIB动态代理两种。

### 3.2 动态代理之JDK动态代理

**在 Java 动态代理机制中 `InvocationHandler` 接口和 `Proxy` 类是核心。**

`Proxy` 类中使用频率最高的方法是：`newProxyInstance()` ，这个方法主要用来生成一个代理对象。

```
public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)
    throws IllegalArgumentException
{
    ......
}
```

* loader：类加载器
* interfaces：被代理类实现的一些接口
* h：实现了 `InvocationHandler` 接口的对象；

要实现动态代理的话，还必须需要实现`InvocationHandler` 来自定义处理逻辑。
当我们的动态代理对象调用一个方法时，这个方法的调用就会被转发到实现`InvocationHandler` 接口类的 `invoke` 方法来调用。

```
public interface InvocationHandler {

/**

* 当你使用代理对象调用方法的时候实际会调用到这个方法
  */
  public Object invoke(Object proxy, Method method, Object[] args)
  throws Throwable;
  }
```

`invoke()` 方法有下面三个参数：

1. **proxy** :动态生成的代理类
2. **method** : 与代理类对象调用的方法相对应
3. **args** : 当前 method 方法的参数

也就是说：**你通过`Proxy` 类的 `newProxyInstance()` 创建的代理对象在调用方法的时候，实际会调用到实现`InvocationHandler` 接口的类的 `invoke()`方法。** 你可以在 `invoke()` 方法中自定义处理逻辑，比如在方法执行前后做什么事情。

#### 3.2.1 动态代理的实现步骤

* 定义一个接口及其实现类；
* 自定义 `InvocationHandler` 并重写`invoke`方法，在 `invoke` 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
* 通过 `Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)` 方法创建代理对象；

**示例代码参见目录：【com.wj.review.project.proxy.dynamic_proxy.jdk】**

### 3.2 动态代理之CGlib动态代理

#### 3.2.1 CGlib简述

**JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。**

**为了解决这个问题，我们可以用 CGLIB 动态代理机制来避免。**

[CGLIB](https://github.com/cglib/cglib)(​*Code Generation Library*​)是一个基于[ASMopen in new window](http://www.baeldung.com/java-asm)的字节码生成库，它允许我们在运行时对字节码进行修改和动态生成。CGLIB 通过继承方式实现代理。很多知名的开源框架都使用到了[CGLIB](https://github.com/cglib/cglib)， 例如 Spring 中的 AOP 模块中：**如果目标对象实现了接口，则默认采用 JDK 动态代理，否则采用 CGLIB 动态代理。**

**在 CGLIB 动态代理机制中 `MethodInterceptor` 接口和 `Enhancer` 类是核心。**

你需要自定义 `MethodInterceptor` 并重写 `intercept` 方法，`intercept` 用于拦截增强被代理类的方法。

```
public interface MethodInterceptor
extends Callback{
    // 拦截被代理类中的方法
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,MethodProxy proxy) throws Throwable;
}
```

1. **obj** : 被代理的对象（需要增强的对象）
2. **method** : 被拦截的方法（需要增强的方法）
3. **args** : 方法入参
4. **proxy** : 用于调用原始方法

你可以通过 `Enhancer`类来动态获取被代理类，当代理类调用方法的时候，实际调用的是 `MethodInterceptor` 中的 `intercept` 方法。

#### 3.2.2 CGLIB 动态代理类使用步骤

* 定义一个类；
* 自定义 `MethodInterceptor` 并重写 `intercept` 方法，`intercept` 用于拦截增强被代理类的方法，和 JDK 动态代理中的 `invoke` 方法类似；
* 通过 `Enhancer` 类的 `create()`创建代理类；

示例代码参见目录：**[com.wj.review.project.proxy.dynamic_proxy.cglib]**

#### 3.2.3 CGLIB 动态代理类和JDK动态代理的对比

* **JDK 动态代理只能代理实现了接口的类或者直接代理接口，而 CGLIB 可以代理未实现任何接口的类。** 另外， CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法。
* 就二者的效率来说，大部分情况都是 JDK 动态代理更优秀，随着 JDK 版本的升级，这个优势更加明显。


## 4.两者的区别

* ​**灵活性**​：动态代理更加灵活，不需要必须实现接口，可以直接代理实现类，并且可以不需要针对每个目标类都创建一个代理类。另外，静态代理中，接口一旦新增加方法，目标对象和代理对象都要进行修改，这是非常麻烦的！
* ​**JVM 层面**​：静态代理在编译时就将接口、实现类、代理类这些都变成了一个个实际的 class 文件。而动态代理是在运行时动态生成类字节码，并加载到 JVM 中的。


