package com.wj.review.project.openfeign.consumer.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-24 11:44
 * @Description: sentinel限流、降级和熔断全局异常处理类
 * 未能生效，来自：https://juejin.cn/post/7152692717284229133
 * To change this template use File | Settings | File and Templates.
 */
//@Configuration
public class SentinelExceptionHandler implements BlockRequestHandler {
   @Override
  public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
    JSONObject resultObj = new JSONObject();
    if (throwable instanceof FlowException) {
      resultObj.put("code", 100);
      resultObj.put("msg", "接口限流");
     }
    if (throwable instanceof DegradeException) {
      resultObj.put("code", 101);
      resultObj.put("msg", "服务降级");
     }
    if (throwable instanceof ParamFlowException) {
      resultObj.put("code", 102);
      resultObj.put("msg", "热点参数限流");
     }
    if (throwable instanceof SystemBlockException) {
      resultObj.put("code", 103);
      resultObj.put("msg", "触发系统保护规则");
     }
    if (throwable instanceof AuthorityException) {
      resultObj.put("code", 104);
      resultObj.put("msg", "授权规则不通过");
     }

    return ServerResponse.status(HttpStatus.BAD_GATEWAY)
         .contentType(MediaType.APPLICATION_JSON)
         .body(BodyInserters.fromValue(resultObj));
   }
}
