package com.jory.thread;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
    public static void main(String[] args) {
//        threadTest();
//        threadSleep();
//        threadSecond();
//        threadMaind();
//        methodManyThread();
//        methodManyThread2();
        threadPool();
    }

    private static void threadTest(){
        //1.获取Thread的子类对象
        MyThread myThread = new MyThread();
        //2.调用start方法,开启新线程,执行run方法
        myThread.start();
        myThread.setName("Mythead");

        System.out.println("1-------------------------------");
        //匿名调用
        new MyThread().start();
        new MyThread().start();
        System.out.println("11-------------------------------");
        System.out.println(Thread.currentThread().getName());
    }
    private static void threadSleep() {
        for (int i = 0; i < 60; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    private static void threadSecond(){
        RunnableImp imp = new RunnableImp();
        Thread thread = new Thread(imp);
        thread.start();
    }

    public static void threadMaind(){
        new Thread() {
            int ticket = 100;
            @Override
            public void run() {
                while (ticket > 1) {
                    System.out.println(ticket + "线程名称："+Thread.currentThread().getName());
                    ticket --;
                }
            }
        }.start();
        System.out.println("-----------"+Thread.currentThread().getName());
        new Thread() {
            int ticket = 50;
            @Override
            public void run() {
                while (ticket > 1) {
                    System.out.println(ticket + " 34线程名称："+Thread.currentThread().getName());
                    ticket --;
                }
            }
        }.start();
    }

    public static void methodManyThread(){
        RunableImpDemo1 demo1 = new RunableImpDemo1();
        Thread thread = new Thread(demo1);
        Thread thread1 = new Thread(demo1);
        Thread thread2 = new Thread(demo1);
        thread2.start();
        thread1.start();
        thread.start();
    }

    public static void methodManyThread2(){
        RunabelImpDemo2 runabelImpDemo2 = new RunabelImpDemo2();
        Thread thread = new Thread(runabelImpDemo2);
        Thread thread1 = new Thread(runabelImpDemo2);
        Thread thread2 = new Thread(runabelImpDemo2);
        thread2.start();
        thread1.start();
        thread.start();
    }
    public static void threadPool(){
        //线程池的使用
        //1.创建固定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new RunnableImp());
        executorService.submit(new RunnableImp());
    }
}
