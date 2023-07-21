package com.wj.review.project.openfeign.consumer.service;

import com.wj.review.project.openfeign.common.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-18 17:35
 * @Description: 该注解@FeignClient中的value属性指定了服务提供者在nacos注册中心的服务名。
 * To change this template use File | Settings | File and Templates.
 */
@FeignClient(value = "openFeign-provider")
public interface FeignProviderService {


     /**
     * 传参方式①：@SpringQueryMap表单传参
     * 参数默认是@RequestBody标注的，
     * 如果通过POJO表单传参的，
     * 使用@SpringQueryMap标注（表单传参）
     */
    @PostMapping("/openfeign/provider/order1")
    Order createOrder1(@SpringQueryMap Order order);

    /**
     * 传参方式②: 传递JSON数据（默认用的就是这种方式）
     * 参数默认是@RequestBody标注的，这里的@RequestBody可以不填
     * 方法名称任意
     * openFeign默认的传参方式就是JSON传参（@RequestBody），
     * 因此定义接口的时候可以不用@RequestBody注解标注，
     * 不过为了规范，一般都填上。
     *
     */
    @PostMapping("/openfeign/provider/order2")
    Order createOrder2(@RequestBody Order order);

     /**
     * 传参方式③：URL中携带参数
     * 通常在provider端使用@PathVariable来接收URL中指定位置上的参数
     */
    @GetMapping("/openfeign/provider/pathParam/{id}")
    String pathParam(@PathVariable("id")Integer id);

     /**
     * 传参方式④：普通表单传递参数
     * 必须要@RequestParam注解标注，且value属性必须填上参数名
     * 方法参数名可以任意，但是@RequestParam注解中的value属性必须和provider中的参数名相同
     */
    @PostMapping("/openfeign/provider/requestParam")
    String requestParam(@RequestParam("id") String arg1,@RequestParam("name") String arg2);






}
