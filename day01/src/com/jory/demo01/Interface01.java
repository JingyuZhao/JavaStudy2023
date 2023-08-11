package com.jory.demo01;

public interface Interface01 {
    public abstract void method1();
    abstract void method2();
    public void method3();
    default void method4(){
        System.out.println("default method4");
    }
}
