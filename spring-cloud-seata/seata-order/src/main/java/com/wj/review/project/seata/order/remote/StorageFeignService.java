package com.wj.review.project.seata.order.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-21 14:00
 * @Description: 库存服务的openFeign接口
 * To change this template use File | Settings | File and Templates.
 */

@FeignClient(value = "seata-strorage")
public interface StorageFeignService {

    /**
     * 扣减库存
     *
     * @param id
     * @param num
     * @return
     */
    @PostMapping("/storage/deduct")
    Object deduct(@RequestParam("id") Long id,@RequestParam("num") Long num);

}
