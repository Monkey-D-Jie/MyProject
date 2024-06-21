package com.demo.wj.review.project.factory_pattern.service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-06-21 15:45
 * @Description: 商品发放的抽象接口类
 * To change this template use File | Settings | File and Templates.
 */

public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
