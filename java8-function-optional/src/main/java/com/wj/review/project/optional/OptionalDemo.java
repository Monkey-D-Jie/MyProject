package com.wj.review.project.optional;

import com.wj.review.project.stream.model.Author;
import com.wj.review.project.stream.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2023-07-17 14:57
 * @Description: 用于测试optional用的类
 * 主要是为了解决开发过程中遇到的空指针异常的问题。
 * 有了它，可以少写跟多 ifxxx 的判断
 * To change this template use File | Settings | File and Templates.
 */

public class OptionalDemo {

    public static void main(String[] args) throws Throwable {
        //optionalHelloWorldTest();
        //optionalFilterTest();
        dataConvertTest();
    }

    private static void dataConvertTest() {
        //我们想获取作家的书籍集合
        Optional<Author> author = Optional.of(getAuthor());
        Optional<List<Book>> books = author.map(Author::getBooks);
        books.ifPresent(System.out::println);
    }

    private static void optionalFilterTest() {
        Optional<Author> author = Optional.ofNullable(getAuthor());
        author.filter(author1 -> author1.getAge()>18).ifPresent(author2 -> System.out.println(author2.getName()));
    }

    private static void optionalHelloWorldTest() throws Throwable {
        Author authorTest = getAuthor();
        System.out.println("==================ifPresent====================");
        Optional<Author> author1 = Optional.ofNullable(authorTest);
        author1.ifPresent(author -> System.out.println(author.getName()));
        System.out.println("==================orElseGet====================");
        Author orElseGetAuthor = author1.orElseGet(Author::new);
        System.out.println(orElseGetAuthor.getName());
        System.out.println("==================orElseThrow====================");
        Author authorNonNull = author1.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("author为空"));
        System.out.println(authorNonNull.getName());

    }

    private static Author getAuthor() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));
        author.setBooks(books1);
        return author;
//        return null;
    }


}
