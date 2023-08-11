package com.jory.lambda;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(234);
        arrList.add(223);
        arrList.add(2138);
        Collections.sort(arrList, (o1,o2) -> o1 - o2);
    }
}
