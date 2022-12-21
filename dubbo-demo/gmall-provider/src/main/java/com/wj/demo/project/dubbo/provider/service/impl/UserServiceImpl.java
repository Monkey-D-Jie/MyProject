package com.wj.demo.project.dubbo.provider.service.impl;

import com.wj.demo.project.dubbo.api.bean.UserAddress;
import com.wj.demo.project.dubbo.api.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 13:57
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

//@Service//使用dubbo提供的Service暴露服务
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl.......");
        UserAddress address1 = new UserAddress(1, "深圳市创业投资大厦", "1", "小明", "010-00000000", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市怡化金融大厦", "2", "小李", "010-11111111", "N");
        System.out.println(address1);
        return Arrays.asList(address1,address2);
    }
}
