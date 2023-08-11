package com.jory.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunabelImpDemo2 implements Runnable{
    int ticket = 1000;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (ticket > 1) {
            lock.lock();
            System.out.println("买票中---------:"+ticket);
            System.out.println(Thread.currentThread().getName());
            ticket --;
            lock.unlock();
        }
    }
}
