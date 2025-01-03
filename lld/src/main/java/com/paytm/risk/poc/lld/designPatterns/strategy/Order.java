package com.paytm.risk.poc.lld.designPatterns.strategy;

public class Order {

    private double amount;
    private PaymentStrategy paymentStrategy;

    public Order(Double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder() {
        System.out.println("Order processing started.");
        paymentStrategy.processPayment(amount);
        System.out.println("Order processing completed.");
    }
}
