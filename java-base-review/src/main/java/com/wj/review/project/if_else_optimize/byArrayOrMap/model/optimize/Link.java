package com.wj.review.project.if_else_optimize.byArrayOrMap.model.optimize;

import com.wj.review.project.if_else_optimize.byArrayOrMap.listener.ShareListener;
import org.apache.http.util.TextUtils;

import static com.wj.review.project.if_else_optimize.byArrayOrMap.common.CommonConstants.TYPE_LINK;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-27 10:39
 * @Description: 各自自行实现的分享类
 * To change this template use File | Settings | File and Templates.
 */

public class Link extends ShareItem2{

    String title;
    String content;
    String link;

    public Link(String link, String title, String content) {
        super(TYPE_LINK);
        this.link = !TextUtils.isEmpty(link) ? link : "default";
        this.title = !TextUtils.isEmpty(title) ? title : "default";
        this.content = !TextUtils.isEmpty(content) ? content : "default";
    }
    @Override
    public void doShare(ShareListener listener) {

    }
}
