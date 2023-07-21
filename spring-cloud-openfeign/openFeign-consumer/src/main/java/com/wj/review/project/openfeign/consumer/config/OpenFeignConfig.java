package com.wj.review.project.openfeign.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-21 16:11
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Configuration
public class OpenFeignConfig {

    /**
     * 设定日志级别
     * 说明
     openFeign虽然提供了日志增强功能，但是默认是不显示任何日志的，
     不过开发者在调试阶段可以自己配置日志的级别。
     各级别说明如下。
     NONE：默认的，不显示任何日志;
     BASIC：仅记录请求方法、URL、响应状态码及执行时间;
     HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息;
     FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
