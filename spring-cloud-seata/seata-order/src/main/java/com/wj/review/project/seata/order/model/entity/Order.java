package com.wj.review.project.seata.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Date;



/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-14 14:19
 * @Description: 订单对象
 * To change this template use File | Settings | File and Templates.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@FieldNameConstants
@Builder
@TableName("t_order")
public class Order{
    Long id;
    Long productId;
    String userId;
    int status;
    Date createTime;
    Long num;
}
