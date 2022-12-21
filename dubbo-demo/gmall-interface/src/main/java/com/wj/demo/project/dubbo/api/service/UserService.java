package com.wj.demo.project.dubbo.api.service;

import com.wj.demo.project.dubbo.api.bean.UserAddress;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 13:55
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public interface UserService {

    List<UserAddress> getUserAddressList(String userId);
}
