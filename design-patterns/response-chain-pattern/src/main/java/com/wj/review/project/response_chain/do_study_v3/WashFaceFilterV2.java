package com.wj.review.project.response_chain.do_study_v3;

import com.wj.review.project.response_chain.event.PreparationList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 14:17
 * @Description: 洗脸事件执行对象
 * To change this template use File | Settings | File and Templates.
 */

public class WashFaceFilterV2 implements StudyPrepareFilter{
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        System.out.println("已洗脸");
        //然后将责任链对象和事件对象传递给下一个，其他类同
        filterChain.doFilter(preparationList,filterChain);
    }
}
