package com.jory.demo02;
interface A1 {

}
interface B1 {

}
interface C1 extends A1,B1 {
    void methodC();
}
class D1 implements C1 {
    @Override
    public void methodC() {
        System.out.println("MethodC.......");
    }
}
public class MultiInterface {
    public static void main(String[] args) {
        //接口指向实现类
        A1 a = new D1();
        B1 b = new D1();
        C1 c = new D1();
        D1 d = new D1();

        //调用实现类的方法
        ((D1)a).methodC();
        ((C1)b).methodC();
        c.methodC();
        d.methodC();

    }
}
