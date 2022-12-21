package com.wj.demo.project.dubbo.provider.service.impl;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 14:15
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.wj.demo.project.dubbo.api.service.HelloService;
import org.springframework.stereotype.Component;

@Component
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}