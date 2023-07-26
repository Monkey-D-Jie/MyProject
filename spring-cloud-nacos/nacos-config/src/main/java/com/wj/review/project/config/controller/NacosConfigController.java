package com.wj.review.project.config.controller;

import com.wj.review.project.config.domain.DynamicConfigEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NacosConfigController {

    private final DynamicConfigEntity entity;


    @GetMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        return "accept one msg id="+id
                +"----- version="+entity.getVersion()+"\\n"
                +"----- url="+entity.getDatabaseUrl()+"\\n"
                +"----- user="+entity.getUser();
    }
 }
