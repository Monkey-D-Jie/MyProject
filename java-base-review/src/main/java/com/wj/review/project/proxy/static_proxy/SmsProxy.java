package com.wj.review.project.proxy.static_proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 15:09
 * @Description: 代理类
 * To change this template use File | Settings | File and Templates.
 */

public class SmsProxy implements SmsService{

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }


    //通过实现接口方法，完成代理，外部调用方法，最终会作用到目标对象中。
    // 在实现了方法调用的同时，还做一些其他的增强（日志打印）操作
    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }


    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("Hello Java");
        /**
         * 输出结果：
         * before method send()
         * send message:Hello Java
         * after method send()
         */
    }
}
