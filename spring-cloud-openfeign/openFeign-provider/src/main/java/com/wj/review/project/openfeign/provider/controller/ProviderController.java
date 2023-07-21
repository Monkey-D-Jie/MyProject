package com.wj.review.project.openfeign.provider.controller;


import com.wj.review.project.openfeign.common.Order;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: wangjie
 * @Date: 2023-07-18 17:36
 * @Description: 这里是描述
 * To change this template use File | Settings | File and Templates.
 */
@RestController
@RequestMapping("/openfeign/provider")
public class ProviderController {

    @PostMapping("/order1")
    @ResponseBody
    public Order createOrder1(Order order) {
         String returnTip = "表单传参==========createOrder1============>>>";
         System.out.println("表单传参==========createOrder1============>>>" + order.toString());
         order.setDesc(returnTip);
         return order;
     }

    @PostMapping("/order2")
    @ResponseBody
    public Order createOrder2(@RequestBody Order order) {
        String returnTip = "JSON传参==========createOrder2============>>>";
        System.out.println("JSON传参==========createOrder2============>>>" + order.toString());
        order.setDesc(returnTip);
        return order;
    }

    /**
     * 使用注解@PathVariable接收url中的占位符
     *
     * @param id
     * @return
     */
    @GetMapping("/pathParam/{id}")
    @ResponseBody
    public String pathParam(@PathVariable("id") Integer id) {
        String returnTip = "@PathVariable传参(接口占位符)==========pathParam============>>>"+id;
        System.out.println(returnTip);
        return returnTip+"accept one msg id=" + id;
    }

    @PostMapping("/requestParam")
    @ResponseBody
    public String requestParam(@RequestParam("id")String id, @RequestParam("name")String name) throws InterruptedException {
        /**
         * 此处主要是用来测试openFeign的超时场景的。
         * openFeign其实是有默认的超时时间的，默认分别是连接超时时间10秒、读超时时间60秒。
         * 具体是在feign包中的Request对象中，
         *  public Options() {
         *             this(10000, 60000);
         * }
         * 那问题来了：为什么此处设置的是3s，它也报了超时的错误呢？
         * 因为openFeign集成了Ribbon，Ribbon的默认超时连接时间、读超时时间都是是1秒。
         * 如果没有显式的设定openFeign的超时时间，
         * 则它会采用Ribbon的默认超时时间。
         * 因此，针对该问题的解决方案也就有了。
         * 在启用了Feign客户端的工程里，选择以下配置
         * 比如本工程，这部分的设置，就该是到consumer工程中去。
            1）设置openFeign的超时时间（推荐的解决方案）
            2）设置Ribbon的超时时间
         */
        Thread.sleep(3000);
        String returnTip = "@RequestParam(接口占位符)==========requestParam============>>>"+id+"---"+name;
        System.out.println(returnTip);
        return returnTip+MessageFormat.format("accept on msg id={0}，name={1}", id, name);
    }
}
