package com.jory.fileoperation;
import java.io.File;

public class Demo02 {
    public static void main(String[] args) {
        //递归方法展示目录下所有文件
//        File test01 = new File("/Users/jory/Desktop/test");
//        getFile(test01);
        File test02 = new File("/Users/jory/Desktop/test");
        getJavaFile(test02);
    }

    private static void getFile(File test01) {
        //1.调用listFiles
        File[] files = test01.listFiles();
        //2.遍历
        for (File file : files) {
            //3.判断是否为文件夹,是则递归调用
            if (file.isDirectory()) {
                System.out.println(file);
                System.out.print("\t--  ");
                getFile(file);
            } else {
                //否则打印
                System.out.println(file);
            }
        }
    }
    private static void getJavaFile(File test01) {
        //1.调用listFiles
        File[] files = test01.listFiles();
        //2.遍历
        for (File file : files) {
            //3.判断是否为文件夹,不为空继续遍历
            if (file.isDirectory()) {
                getJavaFile(file);
            } else {
                //否则判断是否为.java结尾
                if (file.toString().toLowerCase().endsWith(".java")) {
                    System.out.println(file);
                }
            }
        }
    }

}
