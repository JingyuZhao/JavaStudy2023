package com.jory.stream;
/*
方法引用:
    1.如果是函数式接口
    2.如果该方法已存在
    3.就可以使用方法引用
 */
public class Demo02 {
    static void printString(Printable p) {p.print("Hello");}

    /*
    静态方法引用
    */
    static int abs(int num, Calc c) {
        return c.abs(num);
    }

    public static void main(String[] args) {
        methodDemo1();
    }
    static void methodDemo1(){
        //会把p.print(参数)中的参数传给printUpper
        printString(new Obj()::printUpper);
    }

    static void methodDemo2(){
        //使用静态方法引用求绝对值
        int abs = abs(-333, Math::abs);
        System.out.println("-333的绝对值是:" + abs);
    }
}
