package com.wj.review.project.thread_and_multiplethread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Wangjie
 * @Date: 2024-03-20 14:04
 * @Description: ThreadLocal样例代码
 *
 * 原文链接：https://javaguide.cn/java/concurrent/java-concurrent-questions-03.html
 * To change this template use File | Settings | File and Templates.
 */

public class ThreadLocalExample implements Runnable {

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(threadLocalExample,"Thread "+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= " + Thread.currentThread().getName() + "modfied formatter = " + formatter.get().toPattern());
        formatter.remove();
    }
    /**
     部分运行结果摘录
    Thread Name= Thread 0 default Formatter = yyyy-MM-dd HH:mm:ss
    Thread Name= Thread 1 default Formatter = yyyy-MM-dd HH:mm:ss
    Thread Name= Thread 0modfied formatter = yy-M-d ah:mm
    Thread Name= Thread 1modfied formatter = yy-M-d ah:mm

     可以看见，每一个线程都有自己的formatter，就算是改了formatter，也只有当前线程受影响，其他的线程中formatter变量并不会受影响。

     每一个线程通过set方法拿到的都是当前线程的ThreadLocal变量，也就是说，每一个线程都有一份独立的副本，不会相互影响。

     */
}
