package com.wj.demo.project.dubbo.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


@SpringBootApplication
@EnableDubboConfiguration
public class GmallConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallConsumerApplication.class, args);
    }

}
