package com.jory.lambda;

public class LambdaDemo {
    public static void main(String[] args) {


    }
    public static void lambdaDemo1(){
        //Lambda表达式实际上JavaScript中的函数新型表达式
        //格式 ()->{}
        //实现多线程的测试
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("dsjkdasjk");
            }
        }).start();

        new Thread(()->{
            System.out.println("dsaolkdsa");
        }).start();

        new Thread(()-> System.out.println("如果函数体" +
                "只有一行,可以省略大括号.")).start();
    }
    public static void lambdaDemo2(){
        invokeClac(34,45,(a,n)->a+n);
    }
    private static void invokeClac(int a,int b,Caculator caculator){
        int sum = caculator.calc(a,b);
        System.out.println(sum);
    }
}
