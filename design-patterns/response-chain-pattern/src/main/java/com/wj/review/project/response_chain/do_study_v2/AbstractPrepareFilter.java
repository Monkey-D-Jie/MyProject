package com.wj.review.project.response_chain.do_study_v2;

import com.wj.review.project.response_chain.event.PreparationList;
import com.wj.review.project.response_chain.event.Study;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 11:11
 * @Description: 抽象事件过滤器
 * 在这个抽象类中我们需要做的事，
 * 1）抽象出核心流程
 * 2）抽象出非核心流程
 * 在非核心流程中，每一个对象持有下一个对象的引用
 * （这样才能把责任以 链 的形式往下传递起走）
 * To change this template use File | Settings | File and Templates.
 */
public abstract class AbstractPrepareFilter {

    /**
     * 下一个对象的引用
     */
    private AbstractPrepareFilter nextPrepareFilter;

    public AbstractPrepareFilter(AbstractPrepareFilter nextPrepareFilter){
        this.nextPrepareFilter = nextPrepareFilter;
    }


    /**
     * 判断是否抵达核心流程触底的过滤方法
     */
    public void doFilter(PreparationList preparationList, Study study){
        //先要做非核心的事项
        prepare(preparationList);
        if(nextPrepareFilter == null){
            //说明事项已经处理完了
            study.study();
        }else{
            //当前对象处理不了的，就交给下一个对象来处理
            nextPrepareFilter.doFilter(preparationList,study);
        }

    }

    //非核心事项实现抽象
    public abstract void prepare(PreparationList preparationList);
}
