package com.wj.review.project.response_chain.do_study_v2;

import com.wj.review.project.response_chain.event.PreparationList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 11:44
 * @Description: 吃早饭事件执行对象
 * To change this template use File | Settings | File and Templates.
 */
public class HaveBreakfastFilterV1 extends AbstractPrepareFilter{


    public HaveBreakfastFilterV1(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isHavebreakfast()){
            System.out.println("已吃早饭");
        }
    }
}
