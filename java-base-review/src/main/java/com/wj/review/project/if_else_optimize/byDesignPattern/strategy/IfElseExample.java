package com.wj.review.project.if_else_optimize.byDesignPattern.strategy;

import com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize.DiscountPayment;
import com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize.FreePayment;
import com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize.NomalPayment;
import com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize.PaymentContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 15:29
 * @Description: 策略模式-优化前的demo样例
 * 虽然使用简单的if-else能完成功能需求，但是当需求变复杂时，if-else的代码会越来越复杂，
 * 每一个分支下方的代码逻辑会叠加的越来越多，导致代码可读性变差，维护成本也变高。
 * To change this template use File | Settings | File and Templates.
 */

public class IfElseExample {

    //未优化前使用的if-else方法
    public double calculatePayment(double amount) {
        if (amount <= 100) {
            return amount;
        } else if (amount > 100 && amount <= 200) {
            return amount * 0.9; // 10% 折扣
        } else if (amount > 200) {
            return 0; // 免费
        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    //优化前
    public static double beforeOptimize(double amount) {
        IfElseExample example = new IfElseExample();
        double payment = example.calculatePayment(amount);
        return payment;
    }

    //优化后
    public static double afterOptimize(double amount){
        //创建一个上下文对象，并根据传入的金额划定不同的支付方式
        PaymentContext paymentContext = new PaymentContext(new NomalPayment());
        if (amount > 200){
            paymentContext = new PaymentContext(new FreePayment());
        }else{
            paymentContext = new PaymentContext(new DiscountPayment());
        }
        double payment = paymentContext.executeStrategy(amount);
        return payment;
    }

    public static void main(String[] args) {
        double amount = 150;
        System.out.println("before--->支付金额:"+beforeOptimize(amount));
        System.out.println("after--->支付金额:"+afterOptimize(amount));
    }
}
