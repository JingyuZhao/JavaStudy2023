package com.jory.io;

import java.io.*;
import java.util.Properties;

public class IODemo5 {
    public static void main(String[] args) throws IOException {
//        fileWirte();
//        fileArrWirte();
//        tryCatchDemo();
        propertiyDemo();
    }
    public static void fileWirte() throws IOException {
        //字符输出流
        //支持直接输出字符串
        FileWriter fileWriter = new FileWriter("test.txt");
        fileWriter.write("直接输出字符串");
        fileWriter.close();
    }
    public static void fileArrWirte() throws IOException {
        char[] arr = {'我', '是', '中', '国', '人'};
        FileWriter writer = new FileWriter("test.txt");
        writer.write(arr);
        writer.close();
    }
    public static void tryCatchDemo() {
        try {
            FileInputStream inputStream = new FileInputStream("test_image.png");
            FileOutputStream outputStream = new FileOutputStream("test_image_copy.png");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,len);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("异常错误.");
            e.printStackTrace();
        }

    }

    public static void propertiyDemo() throws IOException{
        //Properties唯一和流结合的集合
        //load加载文件中的键值对
        //store保存键值对到文件
        /*
        1.支持#号注释
        2.键值对在内存中必须都是字符串
        3.在文件中无需引号
         */
        Properties properties = new Properties();
        properties.setProperty("name","jory");
        properties.setProperty("age","95");
        properties.setProperty("address","Shanghai");
        properties.store(new FileWriter("test_property.txt"),"");
        System.out.println("保存数据成功");

        Properties readProper = new Properties();
        readProper.load(new FileReader("test_property.txt"));
        System.out.println(readProper);
        String age = readProper.getProperty("age");
        System.out.println(age);

    }
}
