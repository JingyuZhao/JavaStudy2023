package com.jory.demo01;

public interface Interface02 {
    void methodA();
    default void  methodB(){
        System.out.println("Default method2");
    }
    static void  methodC(){
        System.out.println("静态方法，定义时必须要实现");
    }

    //省略了public static final
    //定义的实际上就是常量
    int num = 666;

    void method1();
}
