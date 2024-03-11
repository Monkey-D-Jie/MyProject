package com.wj.review.project.proxy.dynamic_proxy.cglib;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 16:03
 * @Description: 用于演示CGlib代理类的方法类
 * 这里有很明显的优势：即CGlib可以不依赖于接口类的实现，只需要按需添加方法即可。
 * 处理调用端需要调整外，其他地方都不需要做变动。
 *
 * To change this template use File | Settings | File and Templates.
 */

public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
