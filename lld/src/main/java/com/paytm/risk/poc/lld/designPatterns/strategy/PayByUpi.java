package com.paytm.risk.poc.lld.designPatterns.strategy;

public class PayByUpi implements PaymentStrategy{


    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment by UPI for amount "+ amount);

    }
}
