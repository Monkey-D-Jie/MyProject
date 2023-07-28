package com.wj.review.project.openfeign.consumer.controller.sentinelTest;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-28 15:35
 * @Description: 自定义的兜底类方法
 * To change this template use File | Settings | File and Templates.
 */
@Slf4j
public class CustomeBlockHandler {

    /**
     * 在自定义类中的兜底方法
     *
     * 注意
     * ①：方法必须是 public static 修饰
     * ②：返回类型必须和原业务方法相同
     *
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
     public static String handlerQuery2(String p1,String p2,BlockException exception){
        log.info("from CustomeBlockHandler.handlerQuery2---查询商品，p1：{}，p2：{}",p1,p2);
        return "from CustomeBlockHandler.handlerQuery2---查询商品：熔断了......";
    }
}
