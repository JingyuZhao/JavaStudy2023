package com.jory.thread;

public class Customer extends Thread {
    private SteamedStudffedBun steamedStudffedBun;
    public Customer(SteamedStudffedBun steamedStudffedBun) {this.steamedStudffedBun = steamedStudffedBun;}

    @Override
    public void run() {
        while (true){
            synchronized (steamedStudffedBun){
                if (!steamedStudffedBun.isStatus()){
                    try {
                        steamedStudffedBun.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //有包子就开始吃
                System.out.println("顾客正在吃"+
                        steamedStudffedBun.getSkin()+
                        steamedStudffedBun.getFilling()+
                        "包子");
                //包子吃完,修改状态
                steamedStudffedBun.setStatus(false);
                System.out.println("顾客吃完了"+
                        steamedStudffedBun.getSkin()+
                        steamedStudffedBun.getFilling()+
                        "包子");
                System.out.println("-------------------------------");
            }
        }
    }
}
