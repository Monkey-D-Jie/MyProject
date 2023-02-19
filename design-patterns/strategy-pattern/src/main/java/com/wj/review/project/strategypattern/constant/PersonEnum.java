package com.wj.review.project.strategypattern.constant;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-02-19 16:02
 * @Description: 测试人员枚举类
 * To change this template use File | Settings | File and Templates.
 */
@Getter
public enum PersonEnum {

    WANGER("王二","模拟人员1"),
    ZHANGSAN("张三","模拟人员2"),
    LISI("李四","模拟人员3");

    private String curName;
    private String desc;

    PersonEnum(String curName, String desc) {
        this.curName = curName;
        this.desc = desc;
    }
}
