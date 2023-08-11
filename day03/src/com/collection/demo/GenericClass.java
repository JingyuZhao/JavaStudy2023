package com.collection.demo;

import java.util.Collection;

/*
1、定义一个含有泛型的类
2、泛型可以是任何类型
3、创建对象的时候确定泛型类型
* */
public class GenericClass<T> {
    private T name;

    public GenericClass(){

    }
    public GenericClass(T name) {
        this.name = name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public <M> void method(M m) {
        System.out.println("泛型的方法");
    }

    public static <S> void method2(S s) {
        System.out.println("泛型的静态方法");
    }

    //泛型的上限:表示只能是该类型或该类型的子类
    static void getElement1(Collection<? extends Number> collection){}
    //泛型的下限:表示只能是该类型或该类型的父类
    static void getElement2(Collection<? super String> collection){}
}
