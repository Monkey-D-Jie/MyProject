package com.wj.review.project.proxy.static_proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 15:08
 * @Description: 目标对象类
 * To change this template use File | Settings | File and Templates.
 */

public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
