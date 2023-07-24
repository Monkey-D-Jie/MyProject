package com.wj.review.project.openfeign.consumer.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-24 14:55
 * @Description: sentinel的全局异常处理类2，生效了
 * 来自：https://juejin.cn/post/7136107044834115615
 * To change this template use File | Settings | File and Templates.
 */
@Configuration
public class SentinelExceptionHandler2  implements BlockExceptionHandler {
    
    @Override
  public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        if (e instanceof FlowException) {
            //流控规则异常
            response.setStatus(445);

            PrintWriter out = response.getWriter();
            out.print("sentinel======global exception handler");
            out.flush();
            out.close();
        }
        if (e instanceof AuthorityException) {
            //授权规则异常
            System.out.println("i am flow AuthorityException");
        }

        if (e instanceof DegradeException) {
            // 熔断规则
            System.out.println("i am flow DegradeException");
        }


        if (e instanceof ParamFlowException) {
            // 热点规则
            System.out.println("i am flow ParamFlowException");
        }

        if (e instanceof SystemBlockException) {
            // 系统规则
            System.out.println("i am flow SystemBlockException");
        }
    }
}
