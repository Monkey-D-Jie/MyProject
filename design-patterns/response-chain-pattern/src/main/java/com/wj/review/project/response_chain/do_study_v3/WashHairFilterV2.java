package com.wj.review.project.response_chain.do_study_v3;

import com.wj.review.project.response_chain.event.PreparationList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 14:19
 * @Description: 洗头事件执行对象
 * To change this template use File | Settings | File and Templates.
 */

public class WashHairFilterV2 implements StudyPrepareFilter{
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        System.out.println("已洗头");
        filterChain.doFilter(preparationList,filterChain);
    }
}
