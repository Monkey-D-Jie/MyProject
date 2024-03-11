package com.wj.review.project.proxy.dynamic_proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-11 16:08
 * @Description: 获取代理类
 * To change this template use File | Settings | File and Templates.
 */

public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz){
        //创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        //返回代理类增强对象
        return enhancer.create();
    }

}
