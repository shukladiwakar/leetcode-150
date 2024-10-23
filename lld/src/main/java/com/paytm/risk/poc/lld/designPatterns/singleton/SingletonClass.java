package com.paytm.risk.poc.lld.designPatterns.singleton;

public class SingletonClass {
    private static SingletonClass instance;

    private SingletonClass() {

    }

    public static  synchronized SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public void currentObject() {
        System.out.println(this.hashCode());
    }
}
