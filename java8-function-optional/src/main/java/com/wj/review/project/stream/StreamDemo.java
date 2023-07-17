package com.wj.review.project.stream;

import com.wj.review.project.stream.model.Author;
import com.wj.review.project.stream.model.Book;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-17 11:10
 * @Description: 这是一个stream流的使用样例
 * 流式操作作用原理：函数式编程
 * 流式操作用对象：数组或者集合
 * To change this template use File | Settings | File and Templates.
 */

public class StreamDemo {
    public static void main(String[] args) {
        //test1();
        //filterTest();
        //mapTest();
        //distinctTest();
        //sortedAscTest();
        //sortedDescTest();
        //limitTest();
        //skipTest();
        //flatMapTest();
        //flatMapCatagoryTest();
        //countTest();
        //maxOrMinTest();
        //collectListTest();
        //collectSetTest();
        //collectMapTest();
        //findAnyMatchTest();
        //findndAllMatchTest();
        //findNoneMatchTest();
        //findAnyTest();
        //findFirstTest();
        //reduceSumTest();
        //reduceMaxTest();
        //reduceMinTest();
        reduceMinTest2();
    }

    private static void reduceMinTest2() {
        Optional<Integer> reduceMin2 = getAuthors()
                .stream()
                .map(Author::getAge)
                .reduce((result, element) -> result > element ? element : result);
        reduceMin2.ifPresent(System.out::println);
    }

    private static void reduceMinTest() {
        Integer reduceMin = getAuthors()
                .stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result > element ? element : result);
        System.out.println(reduceMin);
    }

    private static void reduceMaxTest() {
        Integer reduce = getAuthors()
                .stream()
                .map(Author::getAge)
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(reduce);
    }

    private static void reduceSumTest() {
       //使用reduce求所有作者年龄的和
        Integer reduce = getAuthors()
                .stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    private static void findFirstTest() {
        //获取一个年龄最小的作家，并输出他的姓名。
        Optional<Author> first = getAuthors()
                .stream()
                .sorted(Comparator.comparingInt(Author::getAge))
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void findAnyTest() {
        //获取任意一个年龄大于18的作家，如果存在就输出他的名字
        Optional<Author> any = getAuthors()
                .stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        any.ifPresent(author -> System.out.println(author.getName()));

    }

    private static void findNoneMatchTest() {
        //判断作家是否都没有超过100岁的。
        boolean b = getAuthors()
                .stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);
    }

    private static void findndAllMatchTest() {
        //判断是否所有的作家都是成年人
        boolean b = getAuthors()
                .stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(b);
    }

    private static void findAnyMatchTest() {
        //判断是否有年龄在29以上的作家
        boolean b = getAuthors()
                .stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);
    }

    private static void collectMapTest() {
        // 获取一个Map集合，map的key为作者名，value为List<Book> 获取一个Map集合，map的key为作者名，value为List<Book>
        Map<String, List<Book>> collectMap = getAuthors()
                .stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(collectMap);
    }

    private static void collectSetTest() {
        //获取一个所有书名的Set集合。
        Set<String> setCollect = getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getName)
                .collect(Collectors.toSet());
        System.out.println(setCollect);
    }

    private static void collectListTest() {
        // 获取一个存放所有作者名字的List集合。
        List<String> collect = getAuthors()
                .stream()
                .map(Author::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void maxOrMinTest() {
      //分别获取这些作家的所出书籍的最高分和最低分并打印。
        Optional<Integer> max = getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max(Comparator.comparingInt(score -> score));
        Optional<Integer> min = getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .min(Comparator.comparingInt(score -> score));
        System.out.println("Max："+max.get()+"，Min:"+min.get());
    }

    private static void countTest() {
        //打印这些作家的所出书籍的数目，注意删除重复元素。
        long count = getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void flatMapCatagoryTest() {
        //打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
        getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);
    }

    private static void flatMapTest() {
        //打印所有书籍的名字。要求对重复的元素进行去重。
        getAuthors()
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void skipTest() {
        //打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
        getAuthors()
                .stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void limitTest() {
//        对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
        getAuthors()
                .stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()+":"+author.getAge()));
    }

    private static void sortedDescTest() {
        //        对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
        getAuthors()
                .stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .forEach(author -> System.out.println(author.getName()+":"+author.getAge()));
    }

    private static void sortedAscTest() {
//        对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
        getAuthors()
                .stream()
                .distinct()
                .sorted()//默认是升序排序
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void distinctTest() {
       //打印所有作家的姓名，并且要求其中不能有重复元素。
        //TODO 需要注意的是：如果去重的对象是非基本类型数据的，则需要重写这些对象的equals方法
        getAuthors()
                .stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void mapTest() {
        //        打印所有作家的姓名
        getAuthors()
                .stream()
                .map(Author::getName)
                .forEach(System.out::println);
    }


    private static void filterTest() {
        //打印所有姓名长度大于1的作家的姓名
        getAuthors()
                .stream()
                .filter(author -> author.getName().length() > 1)
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test1(){
//        打印所有年龄小于18的作家的名字，并且要注意去重
        List<Author> authors = getAuthors();
        authors.
                stream()
                .filter(author -> author.getAge() < 18)
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 获取到用于测试的作家对象集合
     *
     * @return
     */
    public static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追逐不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);
        Author author4 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }



}
