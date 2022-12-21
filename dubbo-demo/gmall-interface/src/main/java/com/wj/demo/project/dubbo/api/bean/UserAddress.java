package com.wj.demo.project.dubbo.api.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2022-12-21 13:54
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Data
@AllArgsConstructor
public class UserAddress implements Serializable {
    private Integer id;
    private String userAddress;
    private String userId;
    private String consignee;
    private String phoneNum;
    private String isDefault;
}
