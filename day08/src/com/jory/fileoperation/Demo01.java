package com.jory.fileoperation;

import java.io.File;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) {
//        printFileSeparator();
        fileCreate();
    }
    public static void printFileSeparator(){
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        //方法1:直接传路径
        File file = new File("/Users/jory/Desktop/DeLogan.java");
        System.out.println(file.getName());
        //方法2:两个路径拼接
        File file02 = new File("/Users/jory/Desktop","DeLogan.java");

        //打印文件长度
        System.out.println("文件长度:" + file02.length());
        //打印文件路径
        System.out.println("文件路径:" + file02.getAbsolutePath());
        System.out.println("文件路径:" + file02.getPath());
        //打印上级文件夹
        System.out.println("上级文件夹:" + file02.getParent());
        //打印文件名称
        System.out.println("文件名称:" + file02.getName());
        //是否存在
        System.out.println("是否存在:" + file02.exists());

        //是否为目录
        System.out.println("是否为目录:" + file02.isDirectory());

        //是否为文件
        System.out.println("是否为文件:" + file02.isFile());

        //是否为隐藏
        System.out.println("是否隐藏:" + file02.isHidden());
    }

    public static  void fileCreate(){
        File root = new File("/Users/jory/Desktop");
        File test = new File(root,"test");
        boolean isSuccess = test.mkdir();
        if (isSuccess) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
        File fileTest = new File(root,"/test/test.txt");
        try {
            boolean isFileSuccess = fileTest.createNewFile();
            if (isFileSuccess) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------");
        //创建多级文件夹
        File file1 = new File(root, "test/test02/test03");
        boolean mkdirs = file1.mkdirs();
        if (mkdirs) {
            System.out.println("创建多级目录成功.");
        } else {
            System.out.println("创建多级目录失败.");
        }
    }
    public static void fileDelete(){

    }
}
