package com.wj.review.project.if_else_optimize.byArrayOrMap.model.optimize;

import com.wj.review.project.if_else_optimize.byArrayOrMap.common.CommonConstants;
import com.wj.review.project.if_else_optimize.byArrayOrMap.listener.ShareListener;
import org.apache.http.util.TextUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-27 10:39
 * @Description: 各自自行实现的分享类
 * To change this template use File | Settings | File and Templates.
 */

public class ImageText extends ShareItem2{

   String content;
    String imagePath;

    public ImageText(String imagePath, String content) {
        super(CommonConstants.TYPE_IMAGE_TEXT);
        this.imagePath = !TextUtils.isEmpty(imagePath) ? imagePath : "default";
        this.content = !TextUtils.isEmpty(content) ? content : "default";
    }
    @Override
    public void doShare(ShareListener listener) {

    }
}
