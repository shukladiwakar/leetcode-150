package com.paytm.risk.poc.lld.designPatterns.strategy;

public class PayByApple implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment by Apple for amount "+ amount);
    }
}
