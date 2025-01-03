//package com.paytm.risk.poc.lld.jackpotGame.dto;
//
//import com.paytm.risk.poc.lld.jackpotGame.RandomNuber;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class JackpotMachine {
//    protected int numberOfChances;
//    Map<Player, List<List<Integer>>> playerListMap;
//    protected int slots;
//
//    List<Player> player;
//    RandomNuber randomNuber;
//
//    public int getNumberOfChances() {
//        return numberOfChances;
//    }
//
//    public void setNumberOfChances(int numberOfChances) {
//        this.numberOfChances = numberOfChances;
//    }
//
//    public JackpotMachine(int numberOfChances) {
//        this.numberOfChances = numberOfChances;
//        this.slots = 3;
//        this.playerListMap = new HashMap<>();
//        player = new ArrayList<>();
//    }
//
////    public void pullLever(Player player) {
////        if (this.playerListMap.containsKey(player)) {
////            playerListMap.put(player, List.of(randomNuber.getRandomNumber(),
////                    randomNuber.getRandomNumber(),
////                    randomNuber.getRandomNumber()));
////        }
////    }
//
//    public void showWinner() {
//
//    }
//
//    public void addPlayers() {
//
//    }
//}
