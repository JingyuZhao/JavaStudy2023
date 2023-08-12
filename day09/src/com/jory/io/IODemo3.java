package com.jory.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo3 {
    public static void main(String[] args) throws IOException{
        copyFile();
    }
    public static void copyFile() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("test.txt"));
        FileOutputStream outputStream = new FileOutputStream(new File("test_out.txt"));
        byte[] bytes = new  byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }
}
