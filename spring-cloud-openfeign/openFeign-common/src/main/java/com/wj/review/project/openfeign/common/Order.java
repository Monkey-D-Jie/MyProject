package com.wj.review.project.openfeign.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-20 10:54
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@Data
@ToString
public class Order implements Serializable {
    private String name;
    private String desc;
    private String orderDate;
}
