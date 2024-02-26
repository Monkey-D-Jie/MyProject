package com.wj.review.project.if_else_optimize.byDesignPattern.strategy.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 15:40
 * @Description: 上下文类，用以封装各策略接口，并完成策略的切换
 * To change this template use File | Settings | File and Templates.
 */

public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double executeStrategy(double amount) {
        return paymentStrategy.calculatePayment(amount);
    }
}
