package com.wj.review.project.openfeign.consumer.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-24 15:53
 * @Description: 全据异常处理，未能生效
//原文链接：https://blog.csdn.net/liaomingwu/article/details/122275201
 * To change this template use File | Settings | File and Templates.
 */

//@Configuration
public class GatewayConfig {

    @PostConstruct
    public void init()
    {
        BlockRequestHandler blockRequestHandler = (exchange, t) -> {

            // 自定义异常处理
            HashMap<String, String> map = new HashMap<>();
            map.put("code", "10099");
            map.put("message", "服务器忙，请稍后再试！");

            return ServerResponse.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(map));
        };

        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }
}
