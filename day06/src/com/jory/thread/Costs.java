package com.jory.thread;

public class Costs extends Thread{
    private SteamedStudffedBun steamedStudffedBun;
    public Costs(SteamedStudffedBun steamedStudffedBun){this.steamedStudffedBun = steamedStudffedBun;}

    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (steamedStudffedBun){
                if (steamedStudffedBun.isStatus()){
                    try {
                        steamedStudffedBun.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (count%3 == 0){
                    steamedStudffedBun.setSkin("猪肉");
                    steamedStudffedBun.setFilling("大葱");
                } else if (count%3 == 1) {
                    //韭菜鸡蛋
                    steamedStudffedBun.setSkin("韭菜");
                    steamedStudffedBun.setFilling("鸡蛋");
                }else{
                    //灌汤包
                    steamedStudffedBun.setSkin("灌汤");
                    steamedStudffedBun.setFilling("包");
                }
                count ++;
                System.out.println("包子铺正在生产"+
                        steamedStudffedBun.getSkin()+
                        steamedStudffedBun.getFilling()+
                        "包子");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //有包子了,修改包子的状态
                steamedStudffedBun.setStatus(true);
                //随机唤醒消费者线程
                steamedStudffedBun.notify();
                System.out.println("您要的包子做好了.");
            }
        }
    }
}
