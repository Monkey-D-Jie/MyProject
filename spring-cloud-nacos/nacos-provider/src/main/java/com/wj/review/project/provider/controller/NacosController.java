package com.wj.review.project.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-26 10:14
 * @Description: 演示服务测试类
 * To change this template use File | Settings | File and Templates.
 */
@RestController
@RequestMapping("/nacos")
public class NacosController {

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id){
        return "accept one msg id="+id;
    }
}
