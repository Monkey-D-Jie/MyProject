package com.wj.review.project.proxy.dynamic_proxy.cglib;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 16:11
 * @Description: 实际使用
 * To change this template use File | Settings | File and Templates.
 */

public class CglibTest {

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("CGlib proxy：Hello java");
    }

}
