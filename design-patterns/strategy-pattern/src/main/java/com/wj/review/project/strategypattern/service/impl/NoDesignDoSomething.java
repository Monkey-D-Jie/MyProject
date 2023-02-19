package com.wj.review.project.strategypattern.service.impl;

import com.wj.review.project.strategypattern.constant.PersonEnum;
import com.wj.review.project.strategypattern.service.DoSomething;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:16
 * @Description: 具体做什么的实现类
 * To change this template use File | Settings | File and Templates.
 */
@Service
public class NoDesignDoSomething implements DoSomething {
    @Override
    public boolean isCurPerson(String curName) {
        return false;
    }

    @Override
    public String eat(String someBody) {
        String eatRet = null;
        //此处不加入设计模式的考虑，直接用if-else，一把梭。肯定是能满足要求的，但不够优雅。
        //如果此处还需要记录某个人中午吃饭的其他明细，就需要在下面的if-else逻辑分支中，
        //加入更多地处理代码。逻辑越多的话，它们就会显得越发冗长。
        if(PersonEnum.WANGER.getCurName().equals(someBody)){
            eatRet = someBody+"吃的兰州拉面";
        }else if(PersonEnum.ZHANGSAN.getCurName().equals(someBody)){
            eatRet = someBody+"吃的猪脚饭";
        }else if(PersonEnum.LISI.getCurName().equals(someBody)){
            eatRet = someBody+"吃的宜宾燃面";
        }
        return eatRet;
    }
}
