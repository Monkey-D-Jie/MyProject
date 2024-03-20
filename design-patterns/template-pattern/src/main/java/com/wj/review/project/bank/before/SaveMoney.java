package com.wj.review.project.bank.before;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:22
 * @Description: 在银行办理存钱业务
 * To change this template use File | Settings | File and Templates.
 */

public class SaveMoney extends BeforeAbstractBankBusinessHandler {
    @Override
    public void handle() {
        System.out.println("I want to save 100 yuan");
    }
}
