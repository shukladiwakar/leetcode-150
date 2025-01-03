package com.paytm.risk.poc.lld.designPatterns.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {
    private static final Map<String, Supplier<PaymentStrategy>> payment = new HashMap<>();

    static {
        registerMethod("credit_card", PayByCreditCard::new);
        registerMethod("upi", PayByUpi::new);
        registerMethod("apple", PayByApple::new);
    }

    static void registerMethod(String method, Supplier<PaymentStrategy> paymentStrategySupplier) {
        payment.put(method, paymentStrategySupplier);
    }

    public static PaymentStrategy getPaymentStrategy(String method) {
        Supplier<PaymentStrategy> paymentStrategySupplier = payment.get(method);

        if (paymentStrategySupplier != null) {
            return paymentStrategySupplier.get();
        }
        throw new IllegalArgumentException("Unkwon Payment Method recieved" + method);
    }
}
