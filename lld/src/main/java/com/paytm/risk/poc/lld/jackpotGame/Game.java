//package com.paytm.risk.poc.lld.jackpotGame;
//
//import com.paytm.risk.poc.lld.jackpotGame.dto.JackpotMachine;
//import com.paytm.risk.poc.lld.jackpotGame.dto.Player;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Game {
//    public static void main(String[] args) {
//
//        List<Player> player = new ArrayList<>();
//        Player p1 = new Player("Diwakar", "1");
//        Player p2 = new Player("Shukla", "2");
//        player.add(p1);
//        player.add(p2);
//        JackpotMachine machine = new JackpotMachine(3);
//
//
//        for (int i = 0; i < player.size(); i++) {
//            for (int j = 0; j < machine.getNumberOfChances(); j++) {
//                machine.pullLever(player.get(i));
//            }
//        }
//
//
//
//    }
//}
