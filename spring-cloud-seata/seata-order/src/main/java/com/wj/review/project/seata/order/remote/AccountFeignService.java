package com.wj.review.project.seata.order.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-21 14:00
 * @Description: 订单服务的openFeign接口
 * To change this template use File | Settings | File and Templates.
 */

@FeignClient(value = "seata-account")
public interface AccountFeignService {

    /**
     * 扣减库存
     *
     * @param id
     * @param num
     * @return
     */
    @PostMapping("/account/deduct")
    Object deduct(@RequestParam("userId") String userId,@RequestParam("money") Long money);

}
