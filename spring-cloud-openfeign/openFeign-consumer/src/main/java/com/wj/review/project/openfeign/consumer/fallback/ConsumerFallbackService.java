package com.wj.review.project.openfeign.consumer.fallback;

import com.wj.review.project.openfeign.common.Order;
import com.wj.review.project.openfeign.consumer.service.FeignProviderService;
import feign.Feign;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-22 18:12
 * @Description: ConsumerService的降级类
 * 可以针对不同的方法，设置不同的降级逻辑
 * To change this template use File | Settings | File and Templates.
 */

@Component
public class ConsumerFallbackService implements FeignProviderService {

    @Override
    public Order createOrder1(Order order) {
        return null;
    }

    @Override
    public Order createOrder2(Order order) {
        return null;
    }

    @Override
    public String createOrder3(List<Order> orderList) {
        return "批量下单服务降级=============";
    }

    @Override
    public String pathParam(Integer id) {
        return null;
    }

    @Override
    public String requestParam(String arg1, String arg2) {
        return null;
    }
}
