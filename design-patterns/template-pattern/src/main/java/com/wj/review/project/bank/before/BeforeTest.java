package com.wj.review.project.bank.before;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 11:26
 * @Description: jdk1.8前的模板方法模式的测试类
 * To change this template use File | Settings | File and Templates.
 */

public class BeforeTest {


    public static void main(String[] args) {
        SaveMoney saveMoney = new SaveMoney();

        DrawMoney drawMoney = new DrawMoney();

        ManageMoney manageMoney = new ManageMoney();
        saveMoney.execute();
        drawMoney.execute();
        manageMoney.execute();
        /**
        运行结果
number-843196447
I want to save 100 yuan
Give it 5 stars
=====================
number-1347906259
I want to draw 500 yuan
Give it 5 stars
=====================
number-696117503
I want to buy 5000 yuan found
Give it 5 stars
=====================

         可见，模板方法很好地将不同的业务需求进行了分离，各自的业务在自定义的拓展上也实现了解耦。
         但这种方法的缺点就是：随着业务种类的增加，每一个业务都需要去实现一个类，如果业务多，类多，代码量会变大，而且类的继承关系会很复杂。
         有没有一种可以在抽象方法的基础上再抽象的模式呢？
         即具体业务操作由外部传入，作为抽象的方法就只需要执行就好了。这样就能规避每增加一类业务就需要新增一个类的缺点？
         有的！
         java8之后，我们可以使用lambda表达式，将具体业务操作作为参数传入，这样就可以避免每增加一类业务就需要新增一个类的缺点。
         */
    }

}
