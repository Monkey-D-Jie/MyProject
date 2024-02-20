package com.wj.review.project.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-14 15:03
 * @Description: 仓储服务的主启动类
 * To change this template use File | Settings | File and Templates.
 */

@SpringBootApplication
@MapperScan("com.wj.review.project.seata.storage.mapper")
public class SeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication.class, args);
    }
}
