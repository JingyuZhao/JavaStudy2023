package com.jory.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/*
消费型函数式接口Consumer<T>:
    1.特点:给什么类型的数据,就消费什么类型的数据
    2.抽象方法:accept(T t)
 */
/*
Consumer接口的默认方法:andThen
    作用:
        1.可以把两个Consumer接口组合在一起
 */
public class Demo03 {
    static void method(String name, Consumer<String> stringConsumer) {
        stringConsumer.accept(name);
    }

    public static void main(String[] args) {
//        consumerDemo();
//        consumerDemo2();
        consumerDemo3();
    }
    static void consumerDemo(){
        method("Java",(String nameInfo)->{
            String reName = new StringBuffer(nameInfo).reverse().toString();
            System.out.println(reName);
        });
    }

    static void methodTwoConsumer(String name,Consumer<String> consumer1,Consumer<String> consumer2) {
        consumer1.andThen(consumer2).accept(name);
    }

    static void consumerDemo2(){
        methodTwoConsumer("Java Hello!",(String info)->{
            System.out.println("Consumer1:-----"+info);
        },(String info)->{
            System.out.println("Consumer2:-----"+info);
        });
    }

    //接口方法
    static void operatorNum(int[] arr,
                            Consumer<Integer> con1,
                            Consumer<Integer> con2) {
        //遍历数组,消费每一个数
        for (int i : arr) {
            con1.andThen(con2).accept(i);
        }
    }

    static void consumerDemo3(){
        //1.定义一个数组
        int[] arr = {111, 2, 222, -333, 33, 555};
        //1.1 定义两个集合,用来存储计算后的结果
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        //2.调用接口方法
        operatorNum(arr, (i) -> {
            i *= 2;
            arr1.add(i);
        }, (i) -> {
            i = i / 2;
            arr2.add(i);
        });
        //3.打印
        System.out.println("原数组:");
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------------");
        System.out.println("数组中每个数乘2的结果为:");
        System.out.println(arr1);
        System.out.println("-------------------------------");
        System.out.println("数组中每个数除以2的结果为:");
        System.out.println(arr2);
    }
}
