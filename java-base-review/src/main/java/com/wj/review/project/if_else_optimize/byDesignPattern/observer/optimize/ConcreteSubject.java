package com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 16:14
 * @Description: 被观察对象的一个具体实现类
 * To change this template use File | Settings | File and Templates.
 */

public class ConcreteSubject implements Subject{

    private List<Observer> observers;
    private String state;

    public ConcreteSubject() {
        //初始化时初始化observers数组
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public String getState() {
        return state;
    }
}
