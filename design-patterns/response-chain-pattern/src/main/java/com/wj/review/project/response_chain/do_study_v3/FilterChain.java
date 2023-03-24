package com.wj.review.project.response_chain.do_study_v3;

import com.wj.review.project.response_chain.event.PreparationList;
import com.wj.review.project.response_chain.event.Study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 14:06
 * @Description: 过滤器链的执行对象
 * To change this template use File | Settings | File and Templates.
 */

public class FilterChain implements StudyPrepareFilter{

    /**
     * 待执行事件的完成情况（同过滤器链的长度相关，当长度与该值相等时，说明待执行事件均已完成）
     */
    private int pos = 0;

    /**
     * 待执行事件对象列表
     * 它们就是用来执行不同事件的
     */
    private List<StudyPrepareFilter> studyPrepareFilterList;
    /**
     * 核心事件执行对象
     * （最后一个做事的人）
     */
    private Study study;

    public FilterChain(Study study) {
        this.study = study;
    }

    /**
     * 执行对象添加方法
     * 借助此方法，将不同的事件执行对象添加进来
     *
     * @param studyPrepareFilter
     */
    public void addFilter(StudyPrepareFilter studyPrepareFilter){
        if(studyPrepareFilterList == null){
            studyPrepareFilterList = new ArrayList<>();
        }
        studyPrepareFilterList.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        //在这里取做具体的事情
        //TODO:此处的“终结条件”就可以很好地应用到具体的业务场景实现中去了
        if(pos == studyPrepareFilterList.size()){
            study.study();
        }else{
           //获取到当前位置的事件执行对象，执行具体操作，然后传递责任链对象
           //此处的pos值变换为：先取值，然后才会加1，进入到下一次的处理流程中去
           studyPrepareFilterList.get(pos++).doFilter(preparationList,filterChain);
        }
    }
}
