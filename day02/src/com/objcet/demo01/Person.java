package com.objcet.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    public Person(){

    }
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person)obj;
        return age == person.age && name == person.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("name",32);
        Person p2 = new Person("name2",23);
        System.out.println(p2.equals(p1));
        System.out.println(p2.hashCode());
//        date();
        dateTest();
    }

   static void date(){
        //构造方法
        Date date = new Date();
        //得到当前日期
        System.out.println(date);
        System.out.println("-------------------------------");

       //带参构造方法
       //将毫秒值转换为日期
       Date date1 = new Date(System.currentTimeMillis());
       System.out.println(date1);

       //常用方法 getTime() 当前时间毫秒值
       System.out.println(new Date().getTime());
       System.out.println(new Date(new Date().getTime()));
    }

    static void dateTest() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",new Locale("ia"));
        Date now = new Date();
        String dateString = format.format(now);
        System.out.println(dateString);

        try {
            Date revalDate = format.parse(dateString);
            System.out.println(revalDate);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

    }
}
