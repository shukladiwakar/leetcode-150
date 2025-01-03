package com.paytm.risk.poc.lld.designPatterns.strategy;

public class PayByCreditCard implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment by Credit Card for amount " + amount);

    }
}
