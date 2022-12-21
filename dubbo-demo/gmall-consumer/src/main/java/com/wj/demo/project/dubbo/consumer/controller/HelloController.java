package com.wj.demo.project.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.demo.project.dubbo.api.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 14:19
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("world");
        System.out.println(helloService.sayHello("SnailClimb"));
        return hello;
    }
}