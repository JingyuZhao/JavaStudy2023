package com.jory.thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("当前线程名"+Thread.currentThread().getName());
    }
    public MyThread(){

    }
    public MyThread(String name) {
        super(name);
    }
}
