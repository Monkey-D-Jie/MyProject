package com.wj.review.project.strategypattern.factory;

import com.wj.review.project.strategypattern.service.DesignDoSomething;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 17:26
 * @Description: 用于生成不同策略对象的工厂类
 * ===>>>> 借助的是 工厂模式的思想
 * To change this template use File | Settings | File and Templates.
 */
@Component
public class StrategyFactory {

    private  final Map<String, DesignDoSomething> DESIGN_STATEGY_MAP = new HashMap<>();


    public  DesignDoSomething getCurStrategy(String curPerName){
        if(CollectionUtils.isEmpty(DESIGN_STATEGY_MAP)){
            throw new RuntimeException("not found what you want object");
        }
        return DESIGN_STATEGY_MAP.get(curPerName);
    }

    public  void registerStrategy(String curPerName, DesignDoSomething strategy){
        DESIGN_STATEGY_MAP.put(curPerName,strategy);
    }


}
