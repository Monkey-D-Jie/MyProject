package com.wj.review.project.if_else_optimize.byDesignPattern.observer;

import com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize.ConcreteObserverA;
import com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize.ConcreteObserverB;
import com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize.ConcreteSubject;
import com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize.Observer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 16:06
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

public class IfElseExample {

    //未优化前使用if-else
    public void beforeOptimize(String state) {
        if ("stateA".equals(state)) {
            // 处理状态A的逻辑
            System.out.println("处理状态A");
        } else if ("stateB".equals(state)) {
            // 处理状态B的逻辑
            System.out.println("处理状态B");
        } else if ("stateC".equals(state)) {
            // 处理状态C的逻辑
            System.out.println("处理状态C");
        } else {
            // 处理其他状态的逻辑
            System.out.println("处理其他状态");
        }
    }

    public void afterOptimize(){
        //创建一个被观察者对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者
        Observer observerA = new ConcreteObserverA();
        Observer observerB = new ConcreteObserverB();
        //添加观察者
        subject.registerObserver(observerA);
        subject.registerObserver(observerB);
        //改变状态，触发通知
        subject.setState("stateA");
        subject.setState("stateB");
        //由于没有stateC对应的观察对象，故此更新不会触发通知
        subject.setState("stateC");

    }

    public static void main(String[] args) {
        IfElseExample example = new IfElseExample();
        //使用未优化前的if-else
        example.beforeOptimize("stateA");
        example.beforeOptimize("stateB");
        example.beforeOptimize("stateC");
        //使用优化后的if-else
        example.afterOptimize();
    }

}
