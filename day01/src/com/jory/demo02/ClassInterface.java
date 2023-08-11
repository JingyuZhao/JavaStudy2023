package com.jory.demo02;
class AA {
    void show()
    {
        System.out.println("AAA");
    }
}
interface BB {
    void eat();
}
class CC extends AA implements BB {

    @Override
    public void eat() {
        System.out.println("CC 的 BB");
    }
}
public class ClassInterface {
    public static void main(String[] args) {
        AA aa = new CC();
        BB bb = new CC();

        //判断a是不是C的实例
        //可以发现,a不仅是C的实例,也是A的实例
        System.out.println(aa instanceof CC);
        System.out.println(aa instanceof AA);

        //可以发现,b不仅是C的实例,同时也是B的实例
        System.out.println(bb instanceof CC);
        System.out.println(bb instanceof BB);

    }
}
