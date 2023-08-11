package com.jory.thread;

/*
创建多线程程序的第二种方法:实现Runnable接口:
    1.创建一个Runnable接口
    2.重写该接口的run方法
    3.创建Runnable实现类
    4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
    5.调用Thread类的start方法,开启新的线程执行run方法
 */
public class RunnableImp implements Runnable{
    @Override
    public void run() {
//        for (int i = 0; i < 20; i++) {
//            System.out.println(Thread.currentThread().getName()+i);
//        }
        System.out.println("创建了一个新先撤个");
    }
}
