package com.jory.function;

import java.util.function.Function;

/*
数据类型转换接口:Function
    1.方法为apply(T t)
    2.泛型接收两个参数
        2.1 第一个参数是转换前的类型
        2.2 第二个参数是转换后的类型

案例:将字符串转换为整数
 */
/*
依赖于Function默认方法andThen,拼接步骤
需求:
    有一个字符串"111",将其转换为整数类型,
    然后乘100,再将结果转换为字符串类型
 */
public class Demo05 {
    static int stringToInter(String s, Function<String,Integer> fun){
        return fun.apply(s);
    }

    static void functionDemo1(){
        int result = stringToInter("403",(numStr)->Integer.parseInt(numStr));
        System.out.println(result);
    }

    public static void main(String[] args) {
//        functionDemo1();
        functionDemo2();
    }

    /*
    分析:
        1.转换用Function接口
        2.转换两次用andThen
        3.参数是字符串
        4.返回值是字符串
     */
    static String getNewString(String s,
                               Function<String, Integer> fun1,
                               Function<Integer, String> fun2) {
        return fun1.andThen(fun2).apply(s);
    }

    static void functionDemo2(){
        //1.定义字符串
        String s = "111";
        //2.调用方法
        String newString = getNewString(s, str -> {
            int i = Integer.parseInt(str);
            i *= 100;
            return i;
        }, i -> String.valueOf(i));
        //3.打印测试
        System.out.println(newString);
    }
}
