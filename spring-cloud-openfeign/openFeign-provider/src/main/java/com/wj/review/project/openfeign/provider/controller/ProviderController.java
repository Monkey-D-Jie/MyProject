package com.wj.review.project.openfeign.provider.controller;


import com.wj.review.project.openfeign.common.Order;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangjie
 * @Date: 2023-07-18 17:36
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@RestController
@RequestMapping("/openfeign/provider")
public class ProviderController {

    @PostMapping("/order1")
    @ResponseBody
    public Order createOrder1(Order order) {
         String returnTip = "表单传参==========createOrder1============>>>";
         System.out.println("表单传参==========createOrder1============>>>" + order.toString());
         order.setDesc(returnTip);
         return order;
     }

    @PostMapping("/order2")
    @ResponseBody
    public Order createOrder2(@RequestBody Order order) {
        String returnTip = "JSON传参==========createOrder2============>>>";
        System.out.println("JSON传参==========createOrder2============>>>" + order.toString());
        order.setDesc(returnTip);
        return order;
    }

    /**
     * 使用注解@PathVariable接收url中的占位符
     *
     * @param id
     * @return
     */
    @GetMapping("/pathParam/{id}")
    @ResponseBody
    public String pathParam(@PathVariable("id") Integer id) {
        String returnTip = "@PathVariable传参(接口占位符)==========pathParam============>>>"+id;
        System.out.println(returnTip);
        return returnTip+"accept one msg id=" + id;
    }


    @PostMapping("/requestParam")
    @ResponseBody
    public String requestParam(@RequestParam("id")String id, @RequestParam("name")String name) {
        String returnTip = "@RequestParam(接口占位符)==========requestParam============>>>"+id+"---"+name;
        System.out.println(returnTip);
        return returnTip+MessageFormat.format("accept on msg id={0}，name={1}", id, name);
    }
}
