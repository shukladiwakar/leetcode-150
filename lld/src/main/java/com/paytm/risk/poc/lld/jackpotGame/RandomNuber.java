//package com.paytm.risk.poc.lld.jackpotGame;
//
//import java.util.concurrent.ThreadLocalRandom;
//
//public class RandomNuber {
//
//    private static RandomNuber randomNuber = null;
//    private int start;
//    private int end;
//
//    private RandomNuber(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    public int getRandomNumber() {
//        if (randomNuber == null) {
//            randomNuber = new RandomNuber(start, end);
//        }
//        return ThreadLocalRandom.current().nextInt(this.start, this.end);
//    }
//}
