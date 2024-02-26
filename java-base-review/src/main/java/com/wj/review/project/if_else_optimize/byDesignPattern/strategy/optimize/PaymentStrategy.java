package com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 15:35
 * @Description: 首先是定一个策略接口，它描述了所有可能策略的共同行为
 * 此处我们就以付钱为例。
 * To change this template use File | Settings | File and Templates.
 */

public interface PaymentStrategy {
    double calculatePayment(double amount);
}

