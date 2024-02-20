package com.wj.review.project.seata.order.service;

import com.wj.review.project.seata.order.model.entity.Order;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-21 14:09
 * @Description: 订单相关接口
 * To change this template use File | Settings | File and Templates.
 */

public interface IOrderService {


    Order create(String userId, Long productId, Long num);


}
