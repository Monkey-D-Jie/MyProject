package com.wj.review.project.generics.erase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-02-20 11:36
 * @Description: Java generics erase 泛型擦除的示例demo类
 * To change this template use File | Settings | File and Templates.
 */

public class GenericsErase<T> {

    public static void main(String[] args) {
        // 1. 只支持引用类型，不支持原始类型
        //编译通过
        List<Integer> integerList = new ArrayList<>();
        //编译失败
//        List<int> integetList2 = new ArrayList<>();
        // 2. 运行时只能对原始类型进行检测
        List<Integer> integerList2 = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        //输出结果是true。虽然两个List的类型不同，但因为‘擦除’机制的存在，它们最终都会变成List类型。
        //此时去比较两个class的类型时，结果自然就是true了。
        System.out.println(integerList2.getClass() == stringList.getClass());
        // 3. 不能实例化类型参数；
        //编译失败
        //T testT = new T();
        // 4. 不能实例化泛型数组；
        //【抛出异常：java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;】
        String[] stringArray = randomTwo("1","2","3");
        System.out.println(stringArray);
    }


    public static <T>  T[] randomTwo(T... t){
        //编译错误
//        T[] array =  new T[2];
        //绕过编译
        T[] array2 = (T[]) new Object[2];
        return array2;
    }
}
