package com.wj.review.project.bank.before;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:23
 * @Description: 在银行办理取钱业务
 * To change this template use File | Settings | File and Templates.
 */

public class DrawMoney extends BeforeAbstractBankBusinessHandler {
    @Override
    public void handle() {
        System.out.println("I want to draw 500 yuan");
    }
}
