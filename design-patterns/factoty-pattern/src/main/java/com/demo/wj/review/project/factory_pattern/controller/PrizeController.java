package com.demo.wj.review.project.factory_pattern.controller;

import com.alibaba.fastjson.JSON;
import com.demo.wj.review.project.factory_pattern.factory.StoreFactory;
import com.demo.wj.review.project.factory_pattern.model.award.AwardReq;
import com.demo.wj.review.project.factory_pattern.model.award.AwardRes;
import com.demo.wj.review.project.factory_pattern.model.card.IQiYiCardService;
import com.demo.wj.review.project.factory_pattern.model.coupon.CouponResult;
import com.demo.wj.review.project.factory_pattern.model.coupon.CouponService;
import com.demo.wj.review.project.factory_pattern.model.goods.DeliverReq;
import com.demo.wj.review.project.factory_pattern.model.goods.GoodsService;
import com.demo.wj.review.project.factory_pattern.service.ICommodity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-06-21 15:04
 * @Description: 模拟奖品发放
 * To change this template use File | Settings | File and Templates.
 */

@Slf4j
public class PrizeController {

    public AwardRes awardToUser(AwardReq req) {
        //1.获取到发奖请求信息
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            //输出奖品发送人信息
            log.info("奖品发放开始{}。req:{}", req.getuId(), reqJson);
            //根据奖品类型，发放不同奖品
            if (1 == req.getAwardType()) {
                //发放优惠券
                log.info("START========发放优惠券=================START");
                CouponService couponService = new CouponService();
                CouponResult couponRet = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponRet.getCode())) {
                    awardRes = new AwardRes("0000", "奖品发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponRet.getInfo());
                }
                log.info("END========发放优惠券=================END");
            } else if (2 == req.getAwardType()) {
                //发放实物
                log.info("START========发放实物=================START");
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean deliverRet = goodsService.deliverGoods(deliverReq);
                if (deliverRet) {
                    awardRes = new AwardRes("0000", "奖品发放成功");
                } else {
                    awardRes = new AwardRes("0001", "奖品发放失败");
                }
                log.info("END========发放实物=================END");
            } else {
                //发放兑换卡
                log.info("START========发放兑换卡=================START");
                IQiYiCardService qrCodeService = new IQiYiCardService();
                qrCodeService.grantToken(queryUserPhoneNumber(req.getuId()), req.getAwardNumber());
                awardRes = new AwardRes("0000", "奖品发放成功");
                log.info("END========发放兑换卡=================END");
            }
            //输出奖品发放结果
            log.info("奖品发放结束{}。res:{}", req.getuId(), JSON.toJSONString(awardRes));
        } catch (Exception e) {
            log.error("奖品发放失败,请求参数:{}", reqJson, e);
            awardRes = new AwardRes("0001", "奖品发放失败");
        }
        return awardRes;
    }


     public void awardToUserWithFactoryPattern(AwardReq req) throws Exception {
          //1.获取到发奖请求信息
        String reqJson = JSON.toJSONString(req);
            //输出奖品发送人信息
            log.info("奖品发放开始{}。req:{}", req.getuId(), reqJson);
            //根据奖品类型，发放不同奖品
            StoreFactory storeFactory = new StoreFactory();
            ICommodity commodityService = storeFactory.getCommodityService(req.getAwardType());
            commodityService.sendCommodity(req.getuId(), req.getAwardNumber(),req.getBizId(), req.getExtMap());
            //输出奖品发放结果
            log.info("奖品发放结束<<<------");
     }

     private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
