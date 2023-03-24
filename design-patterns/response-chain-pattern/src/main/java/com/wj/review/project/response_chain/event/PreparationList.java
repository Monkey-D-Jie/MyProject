package com.wj.review.project.response_chain.event;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 10:28
 * @Description: 执行主流程前需要做的其他事情集合对象
 * 我们定义：
 * 在完成了下面的3件事后，才能执行到主流程：去上学
 * To change this template use File | Settings | File and Templates.
 */
@Data
public class PreparationList {

    /**
     * 洗脸
     */
    private boolean washFace;
    /**
     *洗头
     */
    private boolean washHair;
    /**
     * 吃早饭
     */
    private boolean havebreakfast;


}
