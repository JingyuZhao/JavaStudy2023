package com.jory.demo01;

public interface Interface03 extends Interface01,Interface02{
    // 一个接口可以同时继承多个接口

    @Override
    default void method4() {
        Interface01.super.method4();
    }

    void method5();
}
