package com.wj.review.project.strategypattern.service.impl;

import com.wj.review.project.strategypattern.constant.PersonEnum;
import com.wj.review.project.strategypattern.factory.StrategyFactory;
import com.wj.review.project.strategypattern.service.DesignDoSomething;
import com.wj.review.project.strategypattern.service.DoSomething;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:43
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Service
public class WangErDoSomething extends DesignDoSomething {

    @Autowired
    private StrategyFactory strategyFactory;

    @Override
    public boolean isCurPerson(String curName) {
        return PersonEnum.WANGER.getCurName().equals(curName);
    }

    @Override
    public String eat(String someBody) {
        return someBody+" 吃的兰州拉面";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        strategyFactory.registerStrategy(PersonEnum.WANGER.getCurName(),this);
    }
}
