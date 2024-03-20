package com.wj.review.project.bank.after;

import com.wj.review.project.bank.before.DrawMoney;
import com.wj.review.project.bank.before.ManageMoney;
import com.wj.review.project.bank.before.SaveMoney;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:26
 * @Description: jdk1.8后的模板方法模式的测试类
 * To change this template use File | Settings | File and Templates.
 */

public class AfterTest {


    public static void main(String[] args) {
        AfterBankBusinessHandler afterHandler = new AfterBankBusinessHandler();
        BigDecimal money = new BigDecimal(500);
        afterHandler.saveMoney(money);
        afterHandler.drawMoney(money);
        afterHandler.manageMoney(money);
        /**
         运行结果
（after jdk 1.8）number-1832545523
I want to save 500 yuan
（after jdk 1.8）Give it 5 stars
=====================
（after jdk 1.8）number-983294131
I want to draw 500 yuan
（after jdk 1.8）Give it 5 stars
=====================
（after jdk 1.8）number-1413325599
I want to manage 500 found yuan
（after jdk 1.8）Give it 5 stars
=====================

         从上面的实践结果可知，如果还需要新创建其他的业务，就只需要在handler类中增加方法即可。
         就不需要再新增抽象方法和抽象类了。所有的相关联业务都可以内聚到一个类中。

         办理业务不一样，取号也不一样，如果取号方式不同，又该如何来处理呢？
         优化取号过程即可。
         */
    }

}
