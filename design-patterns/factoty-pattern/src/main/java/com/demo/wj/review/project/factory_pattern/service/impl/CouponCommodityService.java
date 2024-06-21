package com.demo.wj.review.project.factory_pattern.service.impl;

import com.demo.wj.review.project.factory_pattern.model.award.AwardRes;
import com.demo.wj.review.project.factory_pattern.model.card.IQiYiCardService;
import com.demo.wj.review.project.factory_pattern.service.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-06-21 15:47
 * @Description: 发放优惠券
 * To change this template use File | Settings | File and Templates.
 */
@Slf4j
public class CouponCommodityService implements ICommodity {
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
         //发放兑换卡
                log.info("START========发放兑换卡=================START");
                IQiYiCardService qrCodeService = new IQiYiCardService();
                qrCodeService.grantToken(uId, commodityId);
                log.info("END========发放兑换卡=================END");
    }
}
