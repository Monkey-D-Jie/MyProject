package com.wj.review.project.if_else_optimize.byDesignPattern.mediator.optimize;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 17:08
 * @Description: 定义一个中介者接口，用于协调各个同事对象之间的交互
 * To change this template use File | Settings | File and Templates.
 */

public interface Mediator {
    void handle(Colleague colleague);
}
