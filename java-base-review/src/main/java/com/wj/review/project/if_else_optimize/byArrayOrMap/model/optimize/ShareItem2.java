package com.wj.review.project.if_else_optimize.byArrayOrMap.model.optimize;

import com.wj.review.project.if_else_optimize.byArrayOrMap.listener.ShareListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-27 10:38
 * @Description: 优化后的抽象类
 * To change this template use File | Settings | File and Templates.
 */

public abstract class ShareItem2 {
    int type;

    public ShareItem2(int type) {
        this.type = type;
    }

    public abstract void doShare(ShareListener listener);
}
