package com.paytm.risk.poc.lld.designPatterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverClass {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        DriverClass driverClass = new DriverClass();
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.execute(driverClass.createObjects());
        executorService.shutdown();
    }

    Runnable createObjects() {
        return new Runnable() {
            @Override
            public void run() {
                SingletonClass singletonClass = SingletonClass.getInstance();
                System.out.println("Thread current is : " + Thread.currentThread() + "\t");
                singletonClass.currentObject();
                throw new RuntimeException("I am failing");
            }
        };
    }
}
