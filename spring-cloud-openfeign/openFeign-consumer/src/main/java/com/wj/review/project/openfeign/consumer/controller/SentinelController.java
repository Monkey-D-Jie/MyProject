package com.wj.review.project.openfeign.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-24 14:13
 * @Description: sentinel全局异常处理控制层类
 * To change this template use File | Settings | File and Templates.
 */

@RestController
@RequestMapping("/consumer/sentinel")
public class SentinelController {

    @GetMapping("/hello")
    public String hello() {
        return "hi, this is service-sentinel!";
    }

    @PostMapping("/test")
    public String test() {
        return "hi, this is service-sentinel[POST]!";
    }

    //测试流控规则
    @GetMapping("/limit")
    public String limit() { //路由id限流、自定义异常处理
        return "hi, this is service-sentinel-limit test!";
    }

    //测试降级规则
    @GetMapping("/degrade")
    public String degrade() {
        return "hi, this is service-sentinel-degrade test!";
    }

    //熔断测试
    @GetMapping("/fusing")
    public String fusing() {
        return "hi, this is service-sentinel-fusing test!";
    }
}
