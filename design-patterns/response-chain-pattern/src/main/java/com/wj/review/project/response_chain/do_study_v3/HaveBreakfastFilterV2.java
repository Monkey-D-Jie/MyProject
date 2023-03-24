package com.wj.review.project.response_chain.do_study_v3;

import com.wj.review.project.response_chain.event.PreparationList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 14:20
 * @Description: 吃早饭事件执行对象
 * To change this template use File | Settings | File and Templates.
 */

public class HaveBreakfastFilterV2 implements StudyPrepareFilter{
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        System.out.println("已经吃过饭了");
        filterChain.doFilter(preparationList,filterChain);
    }
}
