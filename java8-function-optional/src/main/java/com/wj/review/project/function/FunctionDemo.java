package com.wj.review.project.function;

import com.wj.review.project.stream.model.Author;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.wj.review.project.stream.StreamDemo.getAuthors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-17 15:30
 * @Description: 用于测试常用函数式方法的类
 * To change this template use File | Settings | File and Templates.
 */

public class FunctionDemo {

    public static void main(String[] args) {
        //andTest();
        //orTest();
        //negateTest();
        //baseDataOptimizeTest();
        //parallelTest();
        parallelTest2();
    }

    private static void parallelTest2() {
        getAuthors()
                .parallelStream()
                .map(Author::getAge)
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
    }

    private static void parallelTest() {
         Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer parallelRet = stream.parallel()
                .peek(num -> System.out.println(num + Thread.currentThread().getName()))
                .filter(num -> num > 5)
                .reduce(Integer::sum)
                .get();
        System.out.println(parallelRet);
    }

    private static void baseDataOptimizeTest() {
        //基础数据类型优化，减少不必要的装箱何拆箱
        //常见的方法包括：mapToInt,mapToLong,mapToDouble,flatMapToInt,flatMapToDouble等。
        getAuthors()
                .stream()
                //这样开头，后面都会去做 int与integer间的装箱和拆箱操作
                //.map(Author::getAge)
                //确认类型的前提下，提前对其采用相应的方法，可以减少这种不必要的开销
                .mapToInt(Author::getAge)
                .map(age -> age+10)
                .filter(age -> age > 18)
                .map(age -> age+2)
                .forEach(System.out::println);
    }

    private static void negateTest() {
        //取反操作
        //打印作家中年龄不大于17的作家
        getAuthors()
                .stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 17).negate())
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void orTest() {
        //打印作家中年龄大于17或者姓名的长度小于2的作家
        getAuthors()
                .stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 18)
                        .or(author -> author.getName().length() < 2))
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void andTest() {
        //打印作家中年龄大于17并且姓名的长度大于1的作家
        getAuthors()
                .stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 17)
                        .and(author -> author.getName().length() >= 2))
                .forEach(author -> System.out.println(author.getName()));
    }


}
