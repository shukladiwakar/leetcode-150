package com.paytm.risk.poc.lld.designPatterns.adapter;

// Adaptee
public class LegacyPayPal {
    public void makePayment(String currency, double amount) {
        System.out.println("Payment of " + amount + " " + currency + " made via Legacy PayPal.");
    }
}