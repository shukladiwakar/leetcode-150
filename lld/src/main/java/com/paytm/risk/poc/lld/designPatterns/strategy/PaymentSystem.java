package com.paytm.risk.poc.lld.designPatterns.strategy;

import java.util.Scanner;

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment method (credit_card, paypal, bank_transfer, apple_pay):");
        String paymentMethod = scanner.nextLine().trim();

        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();

        try {
            PaymentStrategy paymentStrategy = PaymentFactory.getPaymentStrategy(paymentMethod);

            Order order = new Order(amount, paymentStrategy);
            order.processOrder();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
