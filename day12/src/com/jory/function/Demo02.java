package com.jory.function;

import java.util.function.Supplier;

public class Demo02 {
    public static String getStringInfo(Supplier<String> stringSupplier) {
        return stringSupplier.get();
    }

    public static void main(String[] args) {
        System.out.println(getStringInfo(()->"H大手大脚卡萨了就快乐的大世界快乐的"));
        int max = maxNumberDemo();
        System.out.println(max);
    }
    static int getMax(Supplier<Integer> integerSupplier) {
        return integerSupplier.get();
    }

    static int maxNumberDemo(){
        int[] numbers = {432,654,236,3,76,3125,7856};
        int max = getMax(()-> {
            int maxValue  = numbers[0];
            for (int i :
                    numbers) {
                if (maxValue < i) {
                    maxValue = i;
                }
            }
            return maxValue;
        });
        return max;
    }
}
