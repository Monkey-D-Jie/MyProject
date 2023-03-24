package com.wj.review.project.response_chain.do_study_v2;

import com.wj.review.project.response_chain.event.PreparationList;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 11:42
 * @Description: 洗头事件执行对象
 * To change this template use File | Settings | File and Templates.
 */
public class WashHairFilterV1 extends AbstractPrepareFilter{

    public WashHairFilterV1(AbstractPrepareFilter nextPrepareFilter){
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isWashHair()){
            System.out.println("已洗头");
        }
    }
}
