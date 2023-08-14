package com.jory.function;

public class Demo01 {
    public static void show(FunctionInterface functionInterface){functionInterface.method();}

    public static void main(String[] args) {
        show(()->System.out.println("我是方法的实现"));
    }
}
