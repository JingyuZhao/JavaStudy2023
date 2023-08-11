package com.jory.list;

import java.util.*;

/*
List集合的特点:
    1.有序
    2.有索引
    3.可以重复
    4、都要考虑越界问题
List集合常用方法:
    1.add(索引,元素) 增加元素到集合
    2.get(索引) 根据索引获取元素
    3.remove(索引) 移除指定索引的元素
    4.set(索引,元素) 替换指定位置的元素
 */
/*
LinkedList集合的特点:
    1.底层是链表,查询慢,增删快
    2.包含了大量操作首尾元素的方法
    3.不能使用多态
 */
public class ListDemo01 {
    public static void main(String[] args) {
//      listLinked();
        listDemo();
    }
    static void listDemo(){
        List<String> list = new ArrayList<>();
        list.add("He894789789893");
        list.add("she");
        list.add("Me2457893");
        String objec= list.get(2);
        list.set(1,"Her");
//        list.add(4,"name");
//        list.remove(4);
        System.out.println(objec);
        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    static void listLinked(){
        //1.removeFirst()
        //2.removeLast()
        //3.pop()
        //4.remove()
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("4392");
        linkedList.add("djjjjdsa");
        linkedList.push("nmadsa");
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.pop();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
