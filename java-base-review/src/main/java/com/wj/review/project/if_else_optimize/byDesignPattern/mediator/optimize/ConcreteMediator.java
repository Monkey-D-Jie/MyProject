package com.wj.review.project.if_else_optimize.byDesignPattern.mediator.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 17:12
 * @Description: 创建一个实现了中介者接口的具体类，该类将根据同事对象的类型执行相应的操作
 * To change this template use File | Settings | File and Templates.
 */

public class ConcreteMediator implements Mediator{
    @Override
    public void handle(Colleague colleague) {
        if (colleague instanceof ConcreteColleagueA) {
            // 处理同事A的逻辑
            System.out.println("处理同事A的请求");
        } else if (colleague instanceof ConcreteColleagueB) {
            // 处理同事B的逻辑
            System.out.println("处理同事B的请求");
        }
        // ... 可以根据需要添加更多的条件分支
    }
}
