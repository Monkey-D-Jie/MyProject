package com.wj.review.project.strategypattern.service;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:09
 * @Description: 人做什么事的接口类
 * ===>>>>>>>> 使用 策略模式 的接口方法
 * ===>>>>>>>> 升级改造，使用工厂模式，让其具有更好的可获取性
 * 改造内容 新增接口继承 initializeBean
 * ===>>>>>>>> 升级改造，为了适配“同样的事情，有的人会做，有的人不需要做”的场景，
 * 引入模板方法，用以区别需要使用的人员。
 * 改造点：
 * ①：变更接口为 abstract class；
 * ②：新增方法，加上不支持调用该方法的声明。
 * To change this template use File | Settings | File and Templates.
 */

public abstract class DesignDoSomething implements InitializingBean {

    /**
     * 判断是否为当前这个人的方法
     *
     * 主要用于实现了该接口的不同‘人’的判断
     *
     * @param curName
     * @return
     */
    public abstract boolean isCurPerson(String curName);
    public abstract String eat(String someBody);

    public void needGarlic(String curName){
        throw new UnsupportedOperationException(curName+"不需要大蒜");
    }

}
