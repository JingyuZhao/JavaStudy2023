package com.jory.map;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {

        //自定义类型作为值
        mapPersonValue();

        //自定义类型作为键
        mapPersonKey();
    }

    private static void mapPersonKey() {
        HashMap<Person, String> personStringHashMap = new HashMap<>();
        personStringHashMap.put(new Person("楚枫", 22), "Java全栈班");
        personStringHashMap.put(new Person("萃萃", 22), "Java基础班");
        personStringHashMap.put(new Person("大黄", 22), "Java基础班");
        System.out.println(personStringHashMap);
        System.out.println("-------------------------------");
    }

    private static void mapPersonValue() {
        HashMap<String, Person> stringPersonHashMap = new HashMap<>();
        stringPersonHashMap.put("Java基础班", new Person("楚枫", 22));
        stringPersonHashMap.put("Java高级班", new Person("萃萃", 22));
        System.out.println(stringPersonHashMap);
        System.out.println("-------------------------------");
    }
}
