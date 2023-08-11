package com.jory.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
/*
HashSet存储自定义类型:
    1.要求该类型重写hash方法和equals方法。否则，会有重复元素
 */
public class SetDemo02 {
    public static void main(String[] args) {
        Person p1 = new Person("name34",12);
        HashSet<Person> personHashSet = new HashSet<>();
        personHashSet.add(new Person("name",34));
        personHashSet.add(new Person("jory",23));
        personHashSet.add(new Person("jory",23));
        personHashSet.add(p1);
        personHashSet.add(p1);
        for (Person p :
                personHashSet) {
            System.out.println(p.getName());
        }

        System.out.println(sum(123,123,789,45));
    }

    static int sum(int... nums){
        int all = 0;
        for (int num:
             nums) {
            all = all + num;
        }
        return all;
    }
}
