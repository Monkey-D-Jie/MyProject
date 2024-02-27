package com.wj.review.project.if_else_optimize.byArrayOrMap.optimize;

import com.wj.review.project.if_else_optimize.byArrayOrMap.common.CommonConstants;
import com.wj.review.project.if_else_optimize.byArrayOrMap.listener.ShareListener;
import com.wj.review.project.if_else_optimize.byArrayOrMap.model.ShareItem;
import com.wj.review.project.if_else_optimize.byArrayOrMap.model.optimize.*;
import org.apache.http.util.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-27 10:04
 * @Description: 分享的一个实现类方法
 * To change this template use File | Settings | File and Templates.
 */

public class OptimizeShareService {

   public void share (ShareItem2 item, ShareListener listener) {
       //1.外部接口，完成对外部传入参数的判断和非空处理
       if (item == null) {
           if (listener != null) {
               listener.onCallback(ShareListener.STATE_FAIL, "ShareItem 不能为 null");
           }
           return;
       }

       if (listener == null) {
           listener = (state, msg) -> System.out.println("ShareListener is null");
       }
       //2.内部接口执行主逻辑，从而减少if-else的判断
       shareImpl(item, listener);
   }

   private void shareImpl (ShareItem2 item, ShareListener listener) {
       //2-1.统一了外部的【空值判断】操作后。内部接口虽然被分离出来了，
       // 但仍然存在if-else比较多的情况。故还需要做进一步的优化。
       //----->将每一个类型剥离出来，各自完成自己的逻辑
       /*if (item.type == CommonConstants.TYPE_LINK) {
           // 分享链接
           if (!TextUtils.isEmpty(item.link) && !TextUtils.isEmpty(item.title)) {
               doShareLink(item.link, item.title, item.content, listener);
           } else {
               listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
           }
       } else if (item.type == CommonConstants.TYPE_IMAGE) {
           // 分享图片
           if (!TextUtils.isEmpty(item.imagePath)) {
               doShareImage(item.imagePath, listener);
           } else {
               listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
           }
       } else if (item.type == CommonConstants.TYPE_TEXT) {
           // 分享文本
           if (!TextUtils.isEmpty(item.content)) {
               doShareText(item.content, listener);
           } else {
               listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
           }
       } else if (item.type == CommonConstants.TYPE_IMAGE_TEXT) {
           // 分享图文
           if (!TextUtils.isEmpty(item.imagePath) && !TextUtils.isEmpty(item.content)) {
               doShareImageAndText(item.imagePath, item.content, listener);
           } else {
               listener.onCallback(ShareListener.STATE_FAIL, "分享信息不完整");
           }
       } else {
           listener.onCallback(ShareListener.STATE_FAIL, "不支持的分享类型");
       }*/
       //根据多态分别实现了各‘分享类’后，此处的调用就比较简单了。
       item.doShare(listener);
   }



    private void doShareImageAndText(String imagePath, String content, ShareListener listener) {
    }

    private void doShareText(String content, ShareListener listener) {
        
    }

    private void doShareImage(String imagePath, ShareListener listener) {
        
    }

    private void doShareLink(String link, String title, String content, ShareListener listener) {
        
    }

    //这种对外提供‘分享对象’方式的好处：省去了调用方对‘分享对象’的获取步骤。
    // 如果不提供这类方法，则调用方需要把‘分享对象’的代码都写一遍。
    public ShareItem2 createLinkShareItem(String link, String title, String content) {
        return new Link(link, title, content);
    }

    public ShareItem2 createImageShareItem(String ImagePath) {
        return new Image(ImagePath);
    }

    public ShareItem2 createTextShareItem(String content) {
        return new Text(content);
    }

    public ShareItem2 createImageTextShareItem(String ImagePath, String content) {
        return new ImageText(ImagePath, content);
    }

    //针对分享类型的另一种优化方法：放在map中获取，
    private Map<Integer, Class<? extends ShareItem2>> map = new HashMap<>();

    private void init() {
        map.put(CommonConstants.TYPE_LINK, Link.class);
        map.put(CommonConstants.TYPE_IMAGE, Image.class);
        map.put(CommonConstants.TYPE_TEXT, Text.class);
        map.put(CommonConstants.TYPE_IMAGE_TEXT, ImageText.class);
    }

    public ShareItem2 createShareItem(int type) {
        try {
            Class<? extends ShareItem2> shareItemClass = map.get(type);
            return shareItemClass.newInstance();
        } catch (Exception e) {
            return new DefaultShareItem(type); // 返回默认实现，不要返回null
        }
}

}
