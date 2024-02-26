package com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 16:17
 * @Description: 观察者1
 * To change this template use File | Settings | File and Templates.
 */

public class ConcreteObserverA implements Observer{
    @Override
    public void update(String state) {
        if ("stateA".equals(state)) {
            System.out.println("观察者A-优化后：处理状态A");
        }
    }
}
