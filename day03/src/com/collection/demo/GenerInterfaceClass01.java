package com.collection.demo;

public class GenerInterfaceClass01<E> implements GenericInterface<E> {

    @Override
    public void methodInterface(E ma) {
        System.out.println(ma);
    }
}
