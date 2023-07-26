package com.wj.review.project.config.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-26 11:39
 * @Description: 获取nacos中的配置项转换对象
 * To change this template use File | Settings | File and Templates.
 */
@Component
@RefreshScope
@Data
public class DynamicConfigEntity {

    //直接读取nacos中config.version的配置
    @Value("${config.version}")
    private String version;

    //获取共享配置文件中database.url
    @Value("${database.url}")
    private String databaseUrl;

    //获取共享配置文件中database.user
    @Value("${database.user}")
    private String user;

}
