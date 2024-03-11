package com.wj.review.project.proxy.dynamic_proxy.jdk;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 15:45
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public class TestJdkProxy {

    public static void main(String[] args) {
        JdkSmsService jdkSmsService = (JdkSmsService) JdkProxyFactory.getProxy(new JdkSmsServiceImpl());
        jdkSmsService.send("Dynamic proxy:Hello java");
    }
}
