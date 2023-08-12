package com.jory.buffer;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) throws IOException ,ClassNotFoundException{
//        copyDemo1();
//        copyDemo2();
//        copyDemo3();
//        writeGBK();
//        writeUTF8();
//        readGBK();
//        readUTF8();
//        wirtePersonObjc();
        readPersonObjc();
    }
    public static void copyDemo1() throws IOException{
        //复制文件
        //方法1.使用字节输入输出流按字节复制
        //1.创建字节输入流
        InputStream inputStream = new FileInputStream("test_image.png");
        //2.创建字节输出流
        OutputStream outputStream = new FileOutputStream("test_demo1.png");
        //3.输入流读取,输出流输出
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        //4.释放
        inputStream.close();
        outputStream.close();
    }
    public static void copyDemo2() throws IOException {
        //复制文件方法2
        //使用输入输出流,每次读写一个字节数组
        //1.创建输入输出流
        FileInputStream fileInputStream = new FileInputStream("test_image.png");
        FileOutputStream fileOutputStream = new FileOutputStream("test_demo2.png");
        //2.操作
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //3.关闭
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static void copyDemo3() throws IOException{
        //复制文件方法3:效率最高,推荐使用
        //使用字节缓冲输入输出流读写
        //1.创建读写缓冲字节流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test_image.png"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test_demo3.png"));
        //2.读写
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        //3.关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void writeUTF8() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("utf8.txt"), "utf-8");
        outputStreamWriter.write("utf8格式的字符串");
        outputStreamWriter.close();
    }

    private static void writeGBK() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk");
        outputStreamWriter.write("GBK格式的字符串");
        outputStreamWriter.close();
    }
    private static void readUTF8() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("utf8.txt"), "utf8");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }

    private static void readGBK() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("gbk.txt"), "gbk");
        int len = 0;
        while ((len = inputStreamReader.read()) != -1) {
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }
    public static void wirtePersonObjc() throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test_model.txt"));
        outputStream.writeObject(new PersonModel("jory",90));
        outputStream.close();
    }
    public static void readPersonObjc() throws IOException,ClassNotFoundException{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test_model.txt"));
        Object object = inputStream.readObject();
        PersonModel model = (PersonModel) object;
        System.out.println(model.getName());
    }

}
