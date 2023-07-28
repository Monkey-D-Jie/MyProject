package com.wj.review.project.openfeign.consumer.controller.sentinelTest;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-28 15:44
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Slf4j
public class FallbackHandler {

    public static String fallback1(){
        return "order-接口-from fallback1---异常处理";
    }

    /**
     * 默认异常降级处理方法，适用于所有服务，参数签名必须为空，但可以有多个Throwable
     *
     * @return
     */
    public static String defaultFallbackHandler(Throwable exception){
        return "降级处理-默认异常处理方法+"+exception.toString();
    }

}
