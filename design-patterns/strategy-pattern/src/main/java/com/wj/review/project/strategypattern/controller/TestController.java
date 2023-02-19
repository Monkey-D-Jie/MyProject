package com.wj.review.project.strategypattern.controller;

import com.wj.review.project.strategypattern.service.DoSomething;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:06
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */

@RestController
public class TestController {

    @Autowired
    private DoSomething doSomething;

    @RequestMapping(value = "/noDesignEat",method = RequestMethod.GET)
    public String getCurPersonEatInfo1(String curPerName){
        return doSomething.eat(curPerName);
    }

    @RequestMapping(value = "/designEat",method = RequestMethod.GET)
    public String getCurPersonEatInfo2(String curPerName){
        return doSomething.eat(curPerName);
    }

}
