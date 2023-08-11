package com.objcet.demo01;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarDemo {
    public static void main(String[] args) {
//        test1();
//        streamDemo();
        stringPrase();
    }
    static void test1(){
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
        System.out.println("--------------------");
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        calendar.set(Calendar.YEAR,2022);
        System.out.println(calendar.get(Calendar.YEAR));
        //打印日历
//        System.out.println(calendar.toString());
        System.out.println("-------------------------------");
        //同时设置年月日
        calendar.set(2022, 5, 21);
        //增加或减少指定的字段
        calendar.add(Calendar.YEAR, 2);
        year = calendar.get(Calendar.YEAR);
        System.out.println("年份:" + year);
        System.out.println("-------------------------------");

        //把日历对象转换为日期对象
        Date time = calendar.getTime();
        //格式化
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println(format);
    }

    static void streamDemo(){
        //字符串缓冲区,可以提供字符串的操作效率
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append(',');
        stringBuffer.append(97);
        stringBuffer.append(33.33);
        stringBuffer.append("你哈哈,java~");

        //打印
        System.out.println(stringBuffer.toString());
        System.out.println("-------------------------------");
        //在hello的后面插入数据
        int index = stringBuffer.indexOf("o");
        index += 1;
        stringBuffer.insert(index, ",world!!!\t");
        System.out.println(stringBuffer.toString());
        System.out.println("-------------------------------");

        //基本类型和字符串之间的转换
        //其他类型转字符串
        int i = 111;
        String s = String.valueOf(i);
        System.out.println(s);
        System.out.println("-------------------------------");


        double i1=11.111;
        String s1 = String.valueOf(i1);

        boolean i2=true;
        String s2 = String.valueOf(i2);

        float i3=333.333F;
        String s3 = String.valueOf(i3);

        System.out.println(s1 + "*" + s2 + "*" + s3);
    }

    static void stringPrase(){
        //字符串转整数
        String s1 = "1";
        int i = Integer.parseInt(s1);
        System.out.println(i);
        System.out.println("-------------------------------");

        //字符串转浮点数
        String s2 = "11.11";
        double i2 = Double.parseDouble(s2);
        System.out.println(i2);
        System.out.println("-------------------------------");

        //字符串转布尔值
        String s3 = "true";
        boolean i3 = Boolean.parseBoolean(s3);
        System.out.println(i3);
        System.out.println("-------------------------------");
    }
}
