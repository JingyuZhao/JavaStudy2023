package com.jory.list;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

/*
Set集合的特点:
    1.不允许重复
    2.没有索引

HashSet的特点:
    1.不重复
    2.没有索引
    3.无序
    4.底层是哈希表结构,查询非常快
 */
public class SetDemo01 {
    public static void main(String[] args) {
//        setTest();
        linkedSetTest();
    }
    static void setTest(){
        HashSet<Integer> integers = new HashSet<>();
        integers.add(12);
        integers.add(23);
        integers.add(90);
        integers.add(12);
        System.out.println(integers);
    }
    static void linkedSetTest(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("dsakodaks");
        Collections.addAll(linkedHashSet,"dsa","34e3ew","dsa");
        System.out.println(linkedHashSet);
    }
}
