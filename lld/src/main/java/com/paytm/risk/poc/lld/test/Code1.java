package com.paytm.risk.poc.lld.test;

import java.util.*;

public class Code1 {
    // Min-heap to store top 10 highest rates
    private PriorityQueue<Double> topRates = new PriorityQueue<>(10);

    // Method to consume new rate from Kafka
    public void consumeNewRate(Double rate) {
        // Add the new rate to the priority queue
        topRates.add(rate);

        // If the size exceeds 10, remove the smallest (head of the queue)
        if (topRates.size() > 10) {
            topRates.poll();
        }
    }

    // Method to return the top 10 highest rates in descending order
    public synchronized Set<Double> getTop10() {
        // Create a TreeSet with reverse order to get descending order
        Set<Double> sortedSet = new TreeSet<>(Collections.reverseOrder());

        // Add all elements from the priority queue to the set
        sortedSet.addAll(topRates);

        return sortedSet;
    }

    public static void main(String[] args) {
        Code1 consumer = new Code1();

        // Example of consuming rates
        Double[] rates = {9.0, 5.0, 6.0, 7.0, 8.0, 0.0, 4.0, 31.0, 1.0, 10.0, 11.0, 14.0};

        for (Double rate : rates) {
            consumer.consumeNewRate(rate);
        }

        // Get top 10 highest rates
        Set<Double> top10Rates = consumer.getTop10();

        // Print the top 10 rates
        System.out.println("Top 10 rates: " + top10Rates);
    }
}
