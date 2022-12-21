package com.wj.demo.project.dubbo.consumer.controller;

import com.wj.demo.project.dubbo.api.bean.UserAddress;
import com.wj.demo.project.dubbo.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 14:03
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid")String userId) {
        return orderService.initOrder(userId);
    }

}
