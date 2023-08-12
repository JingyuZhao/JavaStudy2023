package com.jory.buffer;

import java.io.*;
import java.util.HashMap;

public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {
//        bufferStreamDemo1();
//        bufferStreamInputDemo2();
//        charBufferStreamDemo3();
        charBufferStreamReaderDemo4();

    }
    public static void bufferStreamDemo1() throws IOException{
        //字符缓冲输出流
        /*
        注意:
            1.字节缓冲输出流需要依赖于字节输出流
            2.缓冲类似于传了一个数组,即就是同时传多个字节
            3.关闭的时候会自动调用刷新缓冲的flush功能
         */
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("test_buffer.txt"));
        outputStream.write("我是中国人".getBytes());
        outputStream.flush();
        outputStream.close();
    }
    public static void bufferStreamInputDemo2() throws IOException{
        //字节缓冲输入流
        /*
        注意:
            1.依赖于字节输入流
            2.读取的时候需要自己创建读取的大小数组
         */
        //1.创建字节缓冲输入流对象
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("test_buffer.txt"));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        inputStream.close();
    }

    public static void charBufferStreamDemo3() throws IOException{
        //字符缓冲输出流
        /*
        注意:
            1.带Stream的是字节流,writer和reader是字符流
            2.换行有newline方法
         */
        //1.创建流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test_wirter.txt"));
        //2.写入
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("理想国真恵玩");
            bufferedWriter.newLine();
        }
        //3.释放
        bufferedWriter.close();
    }
    public static void charBufferStreamReaderDemo4() throws IOException{
        //字符缓冲输入流
        /*
        注意:
            1.依赖于FileReader
            2.判断是否读取完毕为null,不再是-1
            3.读取一行的方法是readLine,返回字符串
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test_reader.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void bufferOperationDemo5() throws IOException{
        //对文本内容进行排序
        //1.创建HashMap集合对象
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        //2.创建字符缓冲输入流
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test01.txt"));
        //3.创建字符缓冲输出流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        //4.使用输入流读取数据,按 .进行切割,存到集合中
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //切割
            String[] split = line.split("\\.");
            //5.对集合进行排序,HashMap会自动对key进行排序
            stringStringHashMap.put(split[0], split[1]);
        }
        //6.遍历集合,进行拼接,利用输出流写入
        for (String key : stringStringHashMap.keySet()) {
            String value = stringStringHashMap.get(key);
            line = key + "." + value;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        //7.释放
        bufferedReader.close();
        bufferedWriter.close();
    }
}
