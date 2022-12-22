package com.wj.demo.project.dubbo.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1、导入依赖；
 *         1）、导入dubbo-starter
 *         2）、导入dubbo的其他依赖
 * @author chenhao
 *
 * SpringBoot与dubbo整合的两种方式：
 * 1）、保留dubbo xml配置文件;
 *         导入dubbo-starter，使用@ImportResource导入dubbo的配置文件即可
 * 2）、导入dubbo-starter，在application.properties配置属性，使用@Service【暴露服务】使用@Reference【引用服务】
 */
//@ComponentScan(basePackages = "com.wj.demo.project.dubbo")
@SpringBootApplication
// 开启dubbo的自动配置
@EnableDubboConfiguration
public class GmallProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallProviderApplication.class, args);
    }

}
