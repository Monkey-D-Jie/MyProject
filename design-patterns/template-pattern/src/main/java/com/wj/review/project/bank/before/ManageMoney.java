package com.wj.review.project.bank.before;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:24
 * @Description: 在银行办理理财业务
 * To change this template use File | Settings | File and Templates.
 */

public class ManageMoney extends BeforeAbstractBankBusinessHandler {
    @Override
    public void handle() {
        System.out.println("I want to buy 5000 yuan found");
    }
}
