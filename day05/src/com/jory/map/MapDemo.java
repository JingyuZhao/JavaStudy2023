package com.jory.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Map集合:
    1.存储的是键值对
    2.键不允许重复
    3.HashMap是无序集合
    4.LinkedHashMap是有序集合
 */
public class MapDemo {
    public static void main(String[] args) {
        //集合的添加方法
        //put(键,值) 没有就添加,有就修改,和python字典一样
        mapAdd();

        //集合的删除方法
        //remove(键) 根据键删除值
        //存在返回删除的值,不存在返回null,不会报错
        mapRemove();

        //集合的查找方法
        //get(键) 根据键获取值
        //存在返回值,不存在返回null,不会报错
        mapGet();

        //集合的判断方法
        //containsKey(键) 根据键判断该键值对是否已存在
        //返回对应的布尔值
        mapContains();
        MapKV();
    }
    static void mapAdd(){
        System.out.println("mapAdd--------------------------");
        HashMap<String,String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","jory");
        stringStringHashMap.put("address","河南");
        System.out.println(stringStringHashMap);
    }
    static void mapRemove(){
        System.out.println("mapRemove--------------------------");
        HashMap<String,String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","jory");
        stringStringHashMap.put("address","河南");
        System.out.println(stringStringHashMap);
        stringStringHashMap.remove("name");
        System.out.println(stringStringHashMap);
    }
    static void mapGet(){
        HashMap<String, Boolean> stringBooleanHashMap = new HashMap<>();
        stringBooleanHashMap.put("楚枫", true);
        stringBooleanHashMap.put("萃萃", true);
        stringBooleanHashMap.put("大黄", false);
        System.out.println(stringBooleanHashMap);
        System.out.println("-------------------------------");
        stringBooleanHashMap.remove("大黄");
        System.out.println(stringBooleanHashMap);
        System.out.println("-------------------------------");
        System.out.println("获取楚枫的值:");
        System.out.println(stringBooleanHashMap.get("楚枫"));
        System.out.println("-------------------------------");
        System.out.println("获取已删除的大黄的值:");
        System.out.println(stringBooleanHashMap.get("大黄"));
        System.out.println("-------------------------------");
    }
    static void mapContains(){
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(1, "楚枫");
        integerStringHashMap.put(2, "楚枫");
        integerStringHashMap.put(3, "楚枫");
        System.out.println("判断:");
        System.out.println(integerStringHashMap.containsKey(1));
        System.out.println(integerStringHashMap.containsKey(2));
        System.out.println(integerStringHashMap.containsKey(3));
        System.out.println(integerStringHashMap.containsKey(4));
        System.out.println(integerStringHashMap.containsValue("楚枫"));
    }

    static void MapKV(){
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("楚枫", 22);
        stringIntegerHashMap.put("萃萃", 22);
        stringIntegerHashMap.put("大黄", 322);
        //遍历集合的所有键
        System.out.println("集合所有的键:");
        Set<String> strings = stringIntegerHashMap.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("-------------------------------");
        //遍历集合所有的值
        System.out.println("集合所有的值:");
        Collection<Integer> values = stringIntegerHashMap.values();
        for (Integer value : values) {
            System.out.println(value);
        }
        System.out.println("-------------------------------");
        //遍历集合的所有键值对
        System.out.println("集合所有的键值对:");
        Set<Map.Entry<String, Integer>> entries = stringIntegerHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
        System.out.println("-------------------------------");
    }
}
