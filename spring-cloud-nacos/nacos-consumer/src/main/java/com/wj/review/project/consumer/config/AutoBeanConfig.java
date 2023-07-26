package com.wj.review.project.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-26 10:21
 * @Description: restTemplate注册类
 * To change this template use File | Settings | File and Templates.
 */
@Configuration
public class AutoBeanConfig {


    @LoadBalanced//开启Ribbon支持的负载均衡
    @Bean//注入restTemplate类
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
