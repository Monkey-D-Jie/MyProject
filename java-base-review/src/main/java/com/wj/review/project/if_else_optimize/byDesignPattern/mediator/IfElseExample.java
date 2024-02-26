package com.wj.review.project.if_else_optimize.byDesignPattern.mediator;

import com.wj.review.project.if_else_optimize.byDesignPattern.mediator.optimize.ConcreteColleagueA;
import com.wj.review.project.if_else_optimize.byDesignPattern.mediator.optimize.ConcreteColleagueB;
import com.wj.review.project.if_else_optimize.byDesignPattern.mediator.optimize.ConcreteMediator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 17:04
 * @Description: 中介者模式if-else优化前后对比的测试类
 * To change this template use File | Settings | File and Templates.
 */

public class IfElseExample {

     public void handleRequest(int type) {
        if (type == 1) {
            // 处理类型1的请求
            System.out.println("处理类型1的请求");
        } else if (type == 2) {
            // 处理类型2的请求
            System.out.println("处理类型2的请求");
        }
        // ... 可能还有更多的else if分支
        else {
            // 默认处理或错误处理-形成闭环
        }
    }

    public static void beforeOptimize() {
        IfElseExample example = new IfElseExample();
        example.handleRequest(1);
        example.handleRequest(2);
    }

    public static void afterOptimize() {
        //创建一个中介者
        ConcreteMediator mediator = new ConcreteMediator();
        //创建需要执行具体操作的同事对象
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        //A和B之间相互并不知道对方的存在，但可以有中介者mediator来完成需要的操作
        colleagueA.operation();
        colleagueB.operation();
    }

    public static void main(String[] args) {
        beforeOptimize();
        System.out.println("==========after optimize============");
        afterOptimize();
    }
}
