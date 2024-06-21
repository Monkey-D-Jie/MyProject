package com.demo.wj.review.project.factory_pattern.service.impl;

import com.alibaba.fastjson.JSON;
import com.demo.wj.review.project.factory_pattern.model.award.AwardRes;
import com.demo.wj.review.project.factory_pattern.model.coupon.CouponResult;
import com.demo.wj.review.project.factory_pattern.model.coupon.CouponService;
import com.demo.wj.review.project.factory_pattern.service.ICommodity;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-06-21 15:47
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

@Slf4j
public class CardCommodityService implements ICommodity {
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        //发放优惠券
                log.info("START========发放优惠券=================START");
                CouponService couponService = new CouponService();
                CouponResult couponRet = couponService.sendCoupon(uId, commodityId, bizId);
                log.info("========>>>优惠券发放结果：{}", JSON.toJSONString(couponRet));
                log.info("END========发放优惠券=================END");
    }
}
