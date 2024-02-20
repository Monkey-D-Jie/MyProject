package com.wj.review.project.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wj.review.project.seata.order.mapper.OrderMapper;
import com.wj.review.project.seata.order.model.entity.Order;
import com.wj.review.project.seata.order.remote.AccountFeignService;
import com.wj.review.project.seata.order.remote.StorageFeignService;
import com.wj.review.project.seata.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-21 14:29
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class OderServiceImpl  extends ServiceImpl<OrderMapper,Order> implements IOrderService {

    private final AccountFeignService accountFeignService;

    private final StorageFeignService storageFeignService;

    /**
     *
     * 下订单的业务接口
     * 完成的动作：扣减库存-->扣减余额-->创建订单
     *
     * @GlobalTransactional 表示开启了一个全局的分布式事务
     *
     * @param userId 下单人id
     * @param productId 商品id
     * @param num 商品数量
     */
    @GlobalTransactional
    @Override
    public Order create(String userId, Long productId, Long num) {
        //1.扣减库存
        log.info("---------->>>>>>扣减库存开始");
        storageFeignService.deduct(productId, num);
        log.info("<<<<<<---------扣减库存结束");
        //2.扣减余额
        log.info("----------》》》》》》扣减余额开始");
        //假定商品的单价为20块
        accountFeignService.deduct(userId,20*num);
        log.info("《《《《《《---------扣减余额结束");

        //3.创建订单
        log.info("----------]]]]]]创建订单开始");
        Order curCreateOrder = Order.builder()
                                .userId(userId)
                                .productId(productId)
                                .num(num).status(2)
                                .createTime(new Date())
                                .build();
        log.info("[[[[[[---------创建订单结束");
        this.save(curCreateOrder);
        return curCreateOrder;
    }
}
