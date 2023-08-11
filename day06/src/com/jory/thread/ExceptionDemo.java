package com.jory.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
Throwable:
    1.Exception 程序员能处理的错误
    2.Error 程序员不能处理的错误
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse("2023-08763-99");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        int[] arr = {43,65,23,65,76,12};
        System.out.println(getElement(arr,2));

        method(null);
    }

    private static int getElement(int[] arr,int index) {
        if (arr == null) {
            throw new NullPointerException("数组为空");
        }
        if (index < 0 || index > arr.length) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        return arr[index];
    }

    private static void method(Object o) {
        Objects.requireNonNull(o);
    }
}
