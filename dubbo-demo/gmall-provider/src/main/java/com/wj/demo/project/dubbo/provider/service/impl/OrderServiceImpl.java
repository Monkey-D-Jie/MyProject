package com.wj.demo.project.dubbo.provider.service.impl;

import com.wj.demo.project.dubbo.api.bean.UserAddress;
import com.wj.demo.project.dubbo.api.service.OrderService;
import com.wj.demo.project.dubbo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 14:22
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public class OrderServiceImpl implements OrderService {
    //@Reference
    @Autowired
    UserService userService;
    //@HystrixCommand(fallbackMethod="hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        // TODO Auto-generated method stub
        System.out.println("用户id："+userId);
        //1、查询用户的收货地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        return addressList;
    }
}
