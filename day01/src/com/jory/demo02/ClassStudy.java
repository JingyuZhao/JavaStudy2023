package com.jory.demo02;
class Animal{
    void eat(){
        System.out.println("动物吃东西");
    }
}
class Cat extends Animal {
    void eat() {
        System.out.println("小猫吃鱼");
    }
    void catchMouse(){
        System.out.println("小猫抓老鼠");
    }
}
public class ClassStudy {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();

        ((Cat)animal).catchMouse();

    }
}
