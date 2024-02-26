package com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 15:37
 * @Description: 具体策略2
 * To change this template use File | Settings | File and Templates.
 */

public class DiscountPayment implements PaymentStrategy{
    @Override
    public double calculatePayment(double amount) {
        return amount*0.9;//打九折
    }
}
