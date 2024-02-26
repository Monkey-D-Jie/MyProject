package com.wj.review.project.if_else_optimize.byDesignPattern.observer.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 16:11
 * @Description: 定义一个被观察者接口，
 * 它允许新增和移除观察对象，并允许其他对象观察该对象的内部状态变化。
 * To change this template use File | Settings | File and Templates.
 */

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
