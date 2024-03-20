package com.wj.review.project.bank.before;

import org.apache.commons.lang.math.RandomUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:12
 * @Description: 在JDK1.8前的银行业务处理抽象类
 * To change this template use File | Settings | File and Templates.
 */

public abstract class BeforeAbstractBankBusinessHandler {

    /**
     * 抽象出来的模板方法
     */
    public final void execute(){
        getNumber();
        handle();
        judge();
        System.out.println("=====================");
    }

    /**
     * 取号
     */
    private void getNumber(){
        System.out.println("number-"+ RandomUtils.nextInt());
    }

    /**
     * 办理业务
     * 注：不同的人，办理的业务可能是不一样的，所以此处需要用抽象方法.
     * 具体的由子类实现
     */
    public abstract void handle();

    /**
     * 评价
     */
    private void judge(){
        System.out.println("Give it 5 stars");
    }

}
