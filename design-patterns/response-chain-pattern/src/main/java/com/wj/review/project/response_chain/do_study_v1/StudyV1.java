package com.wj.review.project.response_chain.do_study_v1;

import com.wj.review.project.response_chain.event.PreparationList;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-03-24 10:32
 * @Description: 做了前期准备后将要处理的核心事项
 * To change this template use File | Settings | File and Templates.
 */
@Component
public class StudyV1 {

    public void study(PreparationList preparationList){
        if(preparationList.isWashFace()){
            System.out.println("非核心：洗脸");
        }
        if(preparationList.isWashHair()){
            System.out.println("非核心：洗头");
        }
        if(preparationList.isHavebreakfast()){
            System.out.println("非核心：吃早饭");
        }
        System.out.println("核心流程：可以出门去上学了");
    }

}
