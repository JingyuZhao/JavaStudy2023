package com.jory.stream;

import java.util.*;
import java.util.stream.Stream;

public class Demo01 {
    public static void main(String[] args) {
        streamDemo();
        streamDemo2();
        streamDemo3();
    }
    static void streamDemo() {
        Stream<String> stream = Stream.of("的建行卡上","doas","2wioe3i","dkosapk");
        stream.filter(name -> name.length() >2)
                .filter(name -> name.startsWith("d"))
                .forEach(name -> System.out.println(name));
    }
    static void streamDemo2(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("name");
        arrayList.add("address");
        Stream<String> streamFromArr = arrayList.stream();
        streamFromArr.forEach(info -> System.out.println(info));

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(2389);
        hashSet.add(890);
        Stream<Integer> streamFromInter = hashSet.stream();

        //3.将HashMap的键转换为流
        HashMap<String, Integer> students = new HashMap<>();
        students.put("楚枫",22);
        Stream<String> hashMapKeyStream = students.keySet().stream();

        //4.将HashMap的值转换为流
        Stream<Integer> hashMapValueStream = students.values().stream();

        //5.将HashMap的键值对转换为流
        Stream<Map.Entry<String, Integer>> hashMapKeyValueStream = students.entrySet().stream();

        //6.直接创建流
        Stream<String> roles = Stream.of("楚枫", "萃萃", "大黄");
    }
    /*
    流的映射方法:map
    1.参数是Function接口方法
    2.可以用Lambda优化
    3.将一种类型转换为另一种类型
 */
    static void streamDemo3(){
        //案例:将字符串转换为浮点数
        Stream<String> nums = Stream.of("1", "2.22", "3");
        nums.map(num -> Float.parseFloat(num))
                .forEach(num -> System.out.println(num));
    }
    /*
    流的截取方法:limit
    1.如果截取长度符合条件则截取,不符合不会报错
    */
    static void streamDemo4(){
        String[] arr = {"楚枫", "萃萃", "大黄"};
        //转换为Stream
        Stream<String> stream = Arrays.stream(arr);
        //超出则截取所有,不报错
        Stream<String> limit = stream.limit(4);
        //对截取的进行遍历
        limit.forEach(name -> System.out.println(name));
    }
    /*
    流的跳过方法:skip
    1.用于跳过前面的指定参数个元素
    2.返回值是跳过后剩余元素的新流
    */
    static void streamDemo5(){
        String[] arr = {"楚枫", "萃萃", "大黄", "大黄43", "大34黄"};
        //转换为Stream
        Stream<String> stream = Arrays.stream(arr);
        //跳过前面的2个元素
        Stream<String> limit = stream.skip(2);
        //对截取的进行遍历
        limit.forEach(name -> System.out.println(name));
    }
    static void streamDemo6(){
        String[] arr1 = {"楚枫", "萃萃", "大黄"};
        String[] arr2 = {"楚枫", "萃萃", "大黄"};
        //转换流
        Stream<String> stream = Arrays.stream(arr1);
        Stream<String> stream1 = Arrays.stream(arr2);
        //拼接
        Stream<String> concat = Stream.concat(stream1, stream);
        //遍历
        concat.forEach(System.out::println);
    }
}
