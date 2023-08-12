package com.jory.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
//        ioStream();
//        ioStreamDemo1();
        ioStreamDemo2();
    }
    public static void ioStream(){
        File file = new File("/Users/jory/Desktop/test");
        File text = new File(file,"/text.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(text);
            try {
                fileOutputStream.write(34);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ioStreamDemo1() throws IOException {
        //字节输出流 (没有文件的会创建)
        //常用方法: close flush write
        //1.创建FileOutputStream对象
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        //2.调用write方法
        fileOutputStream.write(97);
        //一次写多个字节的方法
        byte[] arr = {97, 98, 99, 100, 101};
        //write(字节数组)
        fileOutputStream.write(arr);

        //write(字节数组,开始索引,长度)
        fileOutputStream.write(arr, 1, 3);
        //3.释放资源
        fileOutputStream.close();
    }

    public static void ioStreamDemo2() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        fileOutputStream.write("你好".getBytes());
        fileOutputStream.close();
    }
}
