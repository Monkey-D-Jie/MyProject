package com.wj.review.project.openfeign.consumer.controller.sentinelTest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-28 14:19
 * @Description: sentinel实践演示类
 * To change this template use File | Settings | File and Templates.
 */

@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelTestController {


    @GetMapping("/flowLimit/fusing")
    public String test() throws InterruptedException {
        //休眠3秒钟
        Thread.sleep(3000);
        log.info("收到一条消息----flowLimit-fusing");
        return "接收到一条消息----flowLimit-fusing";
    }


    /**
     * 下单接口
     * @return
     */
    @GetMapping("/flowLimit/order")
    @SentinelResource(value = "createOrder"
            ,fallbackClass = FallbackHandler.class
//            ,fallback = "fallback1"
    //能否只用一个方法处理全部的异常？能，必须能，此时就要用到defaultFallback这个属性了，指定默认的降级兜底方法
    ,defaultFallback = "defaultFallbackHandler"
    )
    public String order()  {
        //手动生成异常，触发fallback兜底操作
        System.out.println(1/0);
        return "下单成功..........";
    }

    /**
     * 支付接口
     * @return
     */
    @GetMapping("/flowLimit/pay")
    public String pay()  {
        return "支付成功..........";
    }
     /**
     ********************************************
      */
      /**
      * Created with IntelliJ IDEA.
      * @Author: Wangjie
      * @Date:   2023-07-28 15:13:20
      * @Description: 热点限流实践方法
      */

    /**
     *
     * @SentinelResource的value属性指定了资源名，一定要唯一
     * 借助该注解，我们可以自定义限流返回的异常信息，
     * 其实就是blockHandler指定方法中返回的信息。
     *      * blockHandler属性指定了兜底方法
     * //TODO 需要注意的是
     * ①：兜底方法必须要和业务方法放在同一个类中
     * 如下方的query方法
     * ？这样代码耦合度不是很高吗？
     * ②：@SentinelResource提供一个属性blockHandlerClass，
     * 完美的解决了这一个问题，能够将兜底方法单独放在一个类中。
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/flowLimit/hotSpot")
    //兜底方法形式1
    //@SentinelResource(value = "OrderQuery",blockHandler = "handlerQuery")
    //兜底方法形式2
    @SentinelResource(value = "OrderQuery",blockHandlerClass = CustomeBlockHandler.class,blockHandler = "handlerQuery2")
    public String query(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p2",required = false)String p2) {
        log.info("查询商品，p1：{}，p2：{}",p1,p2);
        return "查询商品：success";
    }

    /**
     * 对应得兜底方法，一旦被限流将会调用这个方法来处理
     */
    public String handlerQuery(@RequestParam(value = "p1",required = false) String p1,
                               @RequestParam(value = "p2",required = false)String p2,
                               BlockException exception){
        log.info("查询商品，p1：{}，p2：{}",p1,p2);
        return "查询商品：熔断了......";
    }


     /**
     ********************************************
      */


}
