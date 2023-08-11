package com.jory.demo01;

public class InterfaceTest implements Interface01,Interface02 {
    public static void main(String[] args) {
        InterfaceTest test = new InterfaceTest();
        test.method4();
        test.methodA();
        test.methodB();
        //调用静态方法
        //接口的静态方法不能够通过实现类对象调用
        Interface02.methodC();
        System.out.println(Interface02.num);

        InterfaceTest2 test2 = new InterfaceTest2();
        test2.method4();

        //如果接口的实现类,或者父类的子类,只需要使用唯一的一次
        //定义
        Interface01 interface01 = new Interface01() {
            @Override
            public void method1() {
                System.out.println("method1");
            }

            @Override
            public void method2() {
                System.out.println("method2");
            }

            @Override
            public void method3() {
                System.out.println("method3");
            }

        };
        //调用方法
        interface01.method3();
    }

    @Override
    public void method1() {
        System.out.println("method1 重名方法只需实现一个.");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }

    @Override
    public void method3() {
        System.out.println("method3");
    }

    @Override
    public void methodA() {
        System.out.println("Interface02 methodA");
    }

//    @Override
//    public void method4() {
//        Interface01.super.method4();
//        System.out.println("mehtod4 ovveride");
//    }
}
class InterfaceTest2 implements Interface03 {

    @Override
    public void methodA() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }

    @Override
    public void method5() {
        System.out.println("method5");
    }

    @Override
    public void method4() {
        Interface03.super.method4();
        System.out.println("djkasjkdakl");
    }
}