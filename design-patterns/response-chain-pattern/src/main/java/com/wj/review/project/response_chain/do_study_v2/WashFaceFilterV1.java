package com.wj.review.project.response_chain.do_study_v2;

import com.wj.review.project.response_chain.event.PreparationList;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 11:40
 * @Description: 洗脸事项执行对象
 * To change this template use File | Settings | File and Templates.
 */
public class WashFaceFilterV1 extends AbstractPrepareFilter{

    public WashFaceFilterV1(AbstractPrepareFilter nextPrepareFilter){
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if(preparationList.isWashFace()){
             System.out.println("已洗脸");
        }
    }
}
