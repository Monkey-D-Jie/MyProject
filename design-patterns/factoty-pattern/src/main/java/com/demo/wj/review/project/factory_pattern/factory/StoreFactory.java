package com.demo.wj.review.project.factory_pattern.factory;

import com.demo.wj.review.project.factory_pattern.service.ICommodity;
import com.demo.wj.review.project.factory_pattern.service.impl.CardCommodityService;
import com.demo.wj.review.project.factory_pattern.service.impl.CouponCommodityService;
import com.demo.wj.review.project.factory_pattern.service.impl.GoodsCommodityService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-06-21 15:54
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        switch (commodityType) {
            case 1:
                return new CouponCommodityService();
            case 2:
                return new GoodsCommodityService();
            case 3:
                return new CardCommodityService();
            default:
                throw new RuntimeException("不存在的商品服务类型");
        }
    }
}
