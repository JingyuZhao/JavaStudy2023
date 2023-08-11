package com.jory.thread;

import java.util.Objects;

public class RunableImpDemo1 implements Runnable{
    int ticket = 1000;
    Object noUse = new Object();
    @Override
    public void run() {
        while (ticket > 1) {
            synchronized (noUse) {
            System.out.println("买票中---------:"+ticket);
            System.out.println(Thread.currentThread().getName());
            ticket --;
            }
        }
    }
}
