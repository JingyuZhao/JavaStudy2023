package com.jory.function;

import java.util.function.Predicate;
/*
Predicate:断言
该接口包含一个test方法,用来判断
 */
/*
Predicate断言接口能够判断:
    1.支持使用and进行与的判断
    2.可用同时判断两个以上的条件

 */
public class Demo04 {
    static boolean checkString(String s, Predicate<String> predicate) {return predicate.test(s);}
    public static void main(String[] args) {
        predicateDemo();
        checkPasswordDemo();
    }
    static void predicateDemo(){
        System.out.println(checkString("name",(name)->{return name.length() > 5;}));
    }

    static boolean checkPassword(String password,
                                 Predicate<String> length,
                                 Predicate<String> upper,
                                 Predicate<String> lower,
                                 Predicate<String> number){
        return length.and(upper).and(lower).and(number).test(password);
    }
    static void checkPasswordDemo(){
        boolean isSuccess = checkPassword("hjas98043Je",
                (password)->{
                return password.length() > 6;
            },
                (password)->{
                    boolean flag = false;
                    char[] chars = password.toCharArray();
                    for (char aChar : chars) {
                        boolean upperCase = Character.isUpperCase(aChar);
                        if (upperCase) {
                            flag = true;
                        }
                    }
                    return flag;
                 },
                (password)->{
                    boolean flag = false;
                    char[] chars = password.toCharArray();
                    for (char aChar : chars) {
                        boolean lowerCase = Character.isLowerCase(aChar);
                        if (lowerCase) {
                            flag = true;
                        }
                    }
                    return flag;
                },
                (password)->{
                    boolean flag = false;
                    char[] chars = password.toCharArray();
                    for (char aChar : chars) {
                        boolean isNum = Character.isDigit(aChar);
                        if (isNum) {
                            flag = true;
                        }
                    }
                    return flag;
                }
                );
        System.out.println(isSuccess);
    }
}
