package com.wj.review.project.proxy.static_proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 15:08
 * @Description: 定义一个接口
 * To change this template use File | Settings | File and Templates.
 */

public interface SmsService {
    String send(String message);
    /**
    如果此处要增加其他的方法,
     代理类和目标对象类，就得按照send的方法，
     都写一遍相应的实现才行。
     既然 静态代理的弊端在于 重复性的实现操作，
     那能不能让它们之间的‘制约’解耦开呢？
     直接根据参数来确定到不同的方法即可，这样就只要一行代码就好了。
     当然有，这就动态代理的作用了。
     */
}
