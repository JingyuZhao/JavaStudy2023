package com.jory.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOReaderDemo4 {
    public static void main(String[] args) throws IOException {
        readerDemo();
    }
    public static void readerDemo() throws IOException {
        //字符输入流
        //FileReader 按字符读取数据,FileInputStream是按字节读取
        //1.创建字符输入流
        FileReader reader = new FileReader(new File("test_out.txt"));
        char[] chars = new  char[1024];
        int len = 0;
        while ((len = reader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        //3.释放资源
        reader.close();

    }
}
