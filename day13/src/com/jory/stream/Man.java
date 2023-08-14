package com.jory.stream;

public class Man extends Human {
    @Override
    public void sayHi() {
        System.out.println("嗨,我是子类Man");
    }
    public void meet(Meet meet) {meet.meet();}

    public void show(){
        meet(super::sayHi);
    }

    public static void main(String[] args) {
        Man man = new Man();
        man.sayHi();
        man.show();
    }
}
