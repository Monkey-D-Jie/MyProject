package com.wj.review.project.consumer.controller;

import com.wj.review.project.consumer.config.AutoBeanConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-26 10:27
 * @Description: 消费者端的请求转发类
 * To change this template use File | Settings | File and Templates.
 */
@RestController
@RequestMapping("/nacos")
@RequiredArgsConstructor
public class NacosConsumerController {

    private final RestTemplate restTemplate;

    @Value("${consumer-config.nacos-provider}")
    private String serviceUrl;

    @GetMapping("/test/{id}")
    public ResponseEntity<String> test(@PathVariable("id") Integer id){
        return restTemplate.getForEntity(serviceUrl+"/nacos/test/"+id,String.class);
    }
 }
