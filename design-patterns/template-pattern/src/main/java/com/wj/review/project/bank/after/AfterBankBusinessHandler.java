package com.wj.review.project.bank.after;

import org.apache.commons.lang.math.RandomUtils;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:12
 * @Description: 在JDK1.8后的银行业务处理抽象类
 * To change this template use File | Settings | File and Templates.
 */

public class AfterBankBusinessHandler {

    /**
     * 抽象出来的模板方法
     * supplier:取号的抽象方法
     * consumer：办理业务的抽象方法
     */
    public final void execute(Supplier<String> supplier, Consumer<BigDecimal> consumer){
        /**
         * JDK1.8以前
        getNumber();
        handle();
        judge();
         */
        /**
         * JDK1.8以后
         */
        getNumberOptimize(supplier);

        //执行的逻辑由外部传入，它在这里只管执行动作。
        consumer.accept(null);
        judge();

        System.out.println("=====================");
    }

    /**
     * 取号
     */
    private void getNumber(){
        System.out.println("（after jdk 1.8）number-"+ RandomUtils.nextInt());
    }

    private void getNumberOptimize(Supplier<String> supplier) {
        String number = supplier.get();
        System.out.println(number);
        if (number.startsWith("vip")) {

            //Vip号分配到VIP柜台

            System.out.println("Assign To Vip Counter");

        } else if (number.startsWith("reservation")) {

            //预约号分配到专属客户经理

            System.out.println("Assign To Exclusive Customer Manager");

        } else {

            //默认分配到普通柜台

            System.out.println("Assign To Usual Manager");

        }

    }

    /**
     * 办理业务
     * 注：不同的人，办理的业务可能是不一样的，所以此处需要用抽象方法.
     * 具体的由子类实现
     * =======>移除handle方法，改由java8的函数式接口实现
     */
    //public abstract void handle();

    /**
     * 评价
     */
    private void judge(){
        System.out.println("（after jdk 1.8）Give it 5 stars");
    }


    //存钱
    public void saveMoney(BigDecimal amount){
        execute(() -> "vipNumber-00" + RandomUtils.nextInt(), bigDecimal -> System.out.println("I want to save "+amount+" yuan"));
    }

    //取钱
    public void drawMoney(BigDecimal amount){
        execute(() -> "reservationNumber-00" + RandomUtils.nextInt(),bigDecimal -> System.out.println("I want to draw "+amount+" yuan"));
    }

    //购买理财基金
    public void manageMoney(BigDecimal amount){
        execute(() -> "number-00" + RandomUtils.nextInt(), bigDecimal ->System.out.println("I want to manage "+amount+" found yuan"));
    }

}
