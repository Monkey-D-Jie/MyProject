package com.wj.review.project.if_else_optimize.byArrayOrMap.orginal;

import com.wj.review.project.if_else_optimize.byArrayOrMap.common.CommonConstants;
import com.wj.review.project.if_else_optimize.byArrayOrMap.listener.ShareListener;
import com.wj.review.project.if_else_optimize.byArrayOrMap.model.ShareItem;
import org.apache.http.util.TextUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-27 10:04
 * @Description: 分享的一个实现类方法
 * To change this template use File | Settings | File and Templates.
 */

public class OriginalShareService {

   public void share (ShareItem item, ShareListener listener) {
    if (item != null) {
        if (item.type == CommonConstants.TYPE_LINK) {
            // 分享链接
            if (!TextUtils.isEmpty(item.link) && !TextUtils.isEmpty(item.title)) {
                doShareLink(item.link, item.title, item.content, listener);
            } else {
                if (listener != null) {
                    listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                }
            }
        } else if (item.type == CommonConstants.TYPE_IMAGE) {
            // 分享图片
            if (!TextUtils.isEmpty(item.imagePath)) {
                doShareImage(item.imagePath, listener);
            } else {
                if (listener != null) {
                    listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                }
            }
        } else if (item.type == CommonConstants.TYPE_TEXT) {
            // 分享文本
            if (!TextUtils.isEmpty(item.content)) {
                doShareText(item.content, listener);
            } else {
                if (listener != null) {
                    listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                }
            }
        } else if (item.type == CommonConstants.TYPE_IMAGE_TEXT) {
            // 分享图文
            if (!TextUtils.isEmpty(item.imagePath) && !TextUtils.isEmpty(item.content)) {
                doShareImageAndText(item.imagePath, item.content, listener);
            } else {
                if (listener != null) {
                    listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
                }
            }
        } else {
            if (listener != null) {
                listener.onCallback(ShareListener.STATE_FAIL, "不支持的分享类型");
            }
        }
    } else {
        if (listener != null) {
            listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
        }
    }
}

    private void doShareImageAndText(String imagePath, String content, ShareListener listener) {
    }

    private void doShareText(String content, ShareListener listener) {
        
    }

    private void doShareImage(String imagePath, ShareListener listener) {
        
    }

    private void doShareLink(String link, String title, String content, ShareListener listener) {
        
    }

}
