package com.wj.review.project.seata.account.model.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-08-14 14:19
 * @Description: 仓储对象
 * To change this template use File | Settings | File and Templates.
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StorageDto implements Serializable {
    Long id;
    String name;
    Long num;
}
