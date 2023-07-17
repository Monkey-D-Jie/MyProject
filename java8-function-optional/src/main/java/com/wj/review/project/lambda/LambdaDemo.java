package com.wj.review.project.lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-17 10:54
 * @Description: lambda表达式的一个样例类
 * To change this template use File | Settings | File and Templates.
 * 2023年7月17日11:05:58 更新
 * 从测验的结果可知，
 * lambda表达式的最为显著的用处即：
 * 可以通过外部传入的函数去控制被调用方法中的参数间的组合逻辑。
 * 这也是java函数式编程的一个基底：它不关心参数的传入的方式，只在乎参数的处理逻辑是怎样的。
 */

public class LambdaDemo {


    public static void main(String[] args) {
         System.out.println("==============calculateNum===============");
        int calculateRet = calculateNum(Integer::sum);
        System.out.println(calculateRet);
        System.out.println("==============printNum===============");
        printNum(value -> value%2==0);
        System.out.println("==============typeConver===============");
        Integer typeConverRet = typeConver(Integer::valueOf);
        System.out.println(typeConverRet);
    }

     public static int calculateNum(IntBinaryOperator operator){
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    public static void printNum(IntPredicate predicate){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        for (int i : arr) {
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }


    public static <R> R typeConver(Function<String,R> function){
        String str = "1235";
        R result = function.apply(str);
        return result;
    }

}
