package com.jory.io;

import java.io.FileInputStream;
import java.io.IOException;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
//        inputDemo1();
        inputDemo2();
    }
    public static void inputDemo1() throws IOException {
        FileInputStream inputStream = new FileInputStream("test.txt");
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            System.out.println(len);
        }
        inputStream.close();
    }
    public static void inputDemo2() throws IOException {
        //一次性读取多个字节
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fileInputStream.close();
    }
}
