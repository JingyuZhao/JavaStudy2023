package com.jory.demo02;

class A {

}

class B extends A{
    void show(){
        System.out.println("Show.....");
    }
}

public class MultiClass {
    public static void main(String[] args) {
        // 父类引用指向子类
        A a= new B();
        // 调用子类的方法是需要向下转型为子类
        ((B) a).show();
    }
}
