package com.wj.review.project.strategypattern.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:09
 * @Description: 人做什么事的接口类
 * To change this template use File | Settings | File and Templates.
 */

public interface DoSomething {

    boolean isCurPerson(String curName);
    String eat(String someBody);

}
