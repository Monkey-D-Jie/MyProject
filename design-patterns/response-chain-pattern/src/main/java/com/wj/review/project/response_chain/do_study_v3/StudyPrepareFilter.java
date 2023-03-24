package com.wj.review.project.response_chain.do_study_v3;

import com.wj.review.project.response_chain.event.PreparationList;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 14:05
 * @Description: 学习事件的整体抽象
 * To change this template use File | Settings | File and Templates.
 */

public interface StudyPrepareFilter {

    void doFilter(PreparationList preparationList, FilterChain filterChain);
}
