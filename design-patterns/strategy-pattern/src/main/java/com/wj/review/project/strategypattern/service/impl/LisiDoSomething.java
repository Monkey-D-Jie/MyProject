package com.wj.review.project.strategypattern.service.impl;

import com.wj.review.project.strategypattern.constant.PersonEnum;
import com.wj.review.project.strategypattern.factory.StrategyFactory;
import com.wj.review.project.strategypattern.service.DesignDoSomething;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:42
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Service
public class LisiDoSomething extends DesignDoSomething {

    @Autowired
    private StrategyFactory strategyFactory;

    @Override
    public boolean isCurPerson(String curName) {
        return PersonEnum.LISI.getCurName().equals(curName);
    }

    @Override
    public String eat(String someBody) {
        return someBody+" 吃的宜宾燃面";
    }

    @Override
    public void needGarlic(String curName) {
        System.out.println(curName+"吃燃面要加大蒜");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        strategyFactory.registerStrategy(PersonEnum.LISI.getCurName(),this);
    }
}
