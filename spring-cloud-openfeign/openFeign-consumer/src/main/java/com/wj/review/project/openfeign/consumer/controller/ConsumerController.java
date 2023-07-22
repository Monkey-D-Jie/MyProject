package com.wj.review.project.openfeign.consumer.controller;

import com.wj.review.project.openfeign.common.Order;
import com.wj.review.project.openfeign.consumer.service.FeignProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-18 17:35
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

@RestController
@RequestMapping("/openfeign/consumer")
@RequiredArgsConstructor
@ResponseBody
public class ConsumerController {

    private  final FeignProviderService feignProvider;

    //@ApiOperation(value = "导入课表", notes = "导入课表")-swagger的注解
    @PostMapping("/order1")
    public Order createOrder1(Order order) {
         return feignProvider.createOrder1(order);
     }

    @PostMapping("/order2")
    public Order createOrder2(@RequestBody Order order) {
        return feignProvider.createOrder2(order);
    }

    @PostMapping("/order3")
    public String createOrder3(@RequestBody List<Order> orderList) {
        return feignProvider.createOrder3(orderList);
    }

    /**
     * 使用注解@PathVariable接收url中的占位符
     *
     * @param id
     * @return
     */
    @GetMapping("/pathParam/{id}")
    public String pathParam(@PathVariable("id") Integer id) {
       return feignProvider.pathParam(id);
    }


    @PostMapping("/requestParam")
    public String requestParam(@RequestParam("id") String id, @RequestParam("name") String name) {
       return feignProvider.requestParam(id,name);
    }

}
