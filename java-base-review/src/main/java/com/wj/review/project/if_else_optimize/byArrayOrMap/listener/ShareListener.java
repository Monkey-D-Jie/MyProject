package com.wj.review.project.if_else_optimize.byArrayOrMap.listener;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-27 10:01
 * @Description: 分享后的回调类
 * To change this template use File | Settings | File and Templates.
 */

public interface ShareListener {
    int STATE_SUCC = 0;
    int STATE_FAIL = 1;

    void onCallback(int state,String msg);
}
