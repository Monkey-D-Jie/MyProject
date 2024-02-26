package com.wj.review.project.if_else_optimize.byDesignPattern.mediator.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 17:09
 * @Description: 创建具体的同事类，每一个类代表实际处理逻辑中的分支
 * To change this template use File | Settings | File and Templates.
 */

public class ConcreteColleagueA implements Colleague{
    //设置中介者协调对象
    private Mediator mediator;

    public ConcreteColleagueA(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void operation() {
        // 具体的业务逻辑
        System.out.println("执行同事A的操作");
        mediator.handle(this);
    }
}
