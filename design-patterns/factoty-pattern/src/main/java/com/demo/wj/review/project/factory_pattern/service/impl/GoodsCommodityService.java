package com.demo.wj.review.project.factory_pattern.service.impl;

import com.demo.wj.review.project.factory_pattern.model.award.AwardRes;
import com.demo.wj.review.project.factory_pattern.model.goods.DeliverReq;
import com.demo.wj.review.project.factory_pattern.model.goods.GoodsService;
import com.demo.wj.review.project.factory_pattern.service.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-06-21 15:47
 * @Description: 发放实物实现
 * To change this template use File | Settings | File and Templates.
 */
@Slf4j
public class GoodsCommodityService implements ICommodity {
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        log.info("START========发放实物=================START");
        GoodsService goodsService = new GoodsService();
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        Boolean deliverRet = goodsService.deliverGoods(deliverReq);
        log.info("------>>>发放实物结果:{}",deliverRet == true ? "发放成功" : "发放失败");
        log.info("END========发放实物=================END");
    }

     private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
