package com.wj.review.project.if_else_optimize.byArrayOrMap.model.optimize;

import com.wj.review.project.if_else_optimize.byArrayOrMap.common.CommonConstants;
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

public class Text extends ShareItem2{

   String content;

    public Text(String content) {
        super(CommonConstants.TYPE_TEXT);
        this.content = !TextUtils.isEmpty(content) ? content : "default";
    }
    @Override
    public void doShare(ShareListener listener) {

    }
}
