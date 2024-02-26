package com.wj.review.project.if_else_optimize.byGuardClauses;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-26 15:29
 * @Description: 使用卫语句优化if-else的前后代码比对的demo样例
 * To change this template use File | Settings | File and Templates.
 * 使用卫语句的好处是：
 * 代码更加清晰简洁，每个条件判断都是独立的，没有嵌套（但有的情况下，还是避免不了嵌套的存在）。
 * 提高了代码的可读性，因为每个条件判断都是明确且独立的。
 * 提高了代码的可维护性，添加或修改条件判断时不需要修改嵌套结构。
 *
 */

public class IfElseExample {

    //未优化前使用的if-else方法
    public static double calculateScholarship(int score) {
        double scholarship = 0;
        //嵌套过多，不利于后续的维护和扩展
        if (score >= 90) {
            if (score >= 95) {
                scholarship = 1000;
            } else {
                scholarship = 500;
            }
        } else if (score >= 80) {
            scholarship = 300;
        } else if (score >= 70) {
            scholarship = 200;
        } else if (score >= 60) {
            scholarship = 100;
        } else {
            scholarship = 0;
        }
        return scholarship;
    }

    //优化前
    public static double beforeOptimize(int score) {
       return calculateScholarship(score);
    }

    public static double calculateScholarship2(int score) {
    if (score < 60) {
        return 0;
    }
    if (score < 70) {
        return 100;
    }
    if (score < 80) {
        return 200;
    }
    if (score < 90) {
        return 300;
    }
    if (score < 95) {
        return 500;
    }
    return 1000;
}

    //优化后
    public static double afterOptimize(int score){
        return calculateScholarship2(score);
    }

    public static void main(String[] args) {
        int amount = 73;
        System.out.println("before--->奖学金:"+beforeOptimize(amount));
        System.out.println("after--->奖学金:"+afterOptimize(amount));
    }
}
