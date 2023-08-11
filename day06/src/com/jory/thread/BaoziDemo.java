package com.jory.thread;

public class BaoziDemo {
    public static void main(String[] args) {
        SteamedStudffedBun baozi = new SteamedStudffedBun();
        Costs costs = new Costs(baozi);
        Customer customer = new Customer(baozi);
        costs.start();
        customer.start();
    }
}
