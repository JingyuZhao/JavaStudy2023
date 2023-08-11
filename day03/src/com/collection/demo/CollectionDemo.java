package com.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("cdzskmldskjl");
        strList.add("world");
        strList.add("1234");
        System.out.println(strList);
        strList.remove("1234");
        System.out.println(strList);
        if (strList.contains("hello")){
            System.out.println("包含");
        }

        if (!strList.isEmpty()){
            System.out.println("是否是空");
        }

        Object[] arr = strList.toArray();
        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String str:
            strList) {
            System.out.println(str);
        }
    }
}
