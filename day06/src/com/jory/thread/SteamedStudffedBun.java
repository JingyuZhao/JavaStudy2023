package com.jory.thread;

public class SteamedStudffedBun {
    // 皮儿
    private String skin;
    // 馅儿
    private String filling;
    // 包子有无
    private boolean status;

    public SteamedStudffedBun(){

    }
    public SteamedStudffedBun(String skin,String filling,boolean status){
        this.skin = skin;
        this.filling = filling;
        this.status = status;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "SteamedStuffedBun{" +
                "skin='" + skin + '\'' +
                ", filling='" + filling + '\'' +
                ", status=" + status +
                '}';
    }
}
