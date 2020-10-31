package com.spring.hockeystats;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private ArrayList<Player> playerList;
    Scanner scan = new Scanner(System.in);

    public void game(){
        while (true){
            System.out.println("Would you like to play blackjack y or n?: ");
            String ans = scan.nextLine().toLowerCase();
            if (ans.contains("y")){
                setupGame();
                hitStay();
            } else {
                break;
            }
        }
    }

    public void setupGame(){
        deck = new Deck();
        generatePlayers();
        dealer = new Dealer(new Hand());
        deck.shuffle();

        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
    }

    public void generatePlayers() {
        ArrayList<Player> playerList = new ArrayList<>();
        System.out.println("What is this players name?: ");
        String name = scan.nextLine();
        Player player = new Player(new Hand(), name);
        playerList.add(player);
        String addPlayer;
        while (true){
            System.out.println("Would you like to add another player y or n?");
            addPlayer = scan.nextLine();
            if(addPlayer.toLowerCase().contains("y")) {
                System.out.println("What is this players name?: ");
                String playerName = scan.nextLine();
                Player newPlayer = new Player(new Hand(), playerName);
                playerList.add(newPlayer);
                continue;
            }
            break;
        }
        this.playerList = playerList;
    }

    public void newDeal(){
        player.clearHand();
        dealer.clearHand();
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        checkBlackjack();
    }

    public void checkBlackjack(){
        if(dealer.isBlackjack()){
            System.out.println("Dealer has Blackjack");
            if(player.isBlackjack()){
                System.out.println("Player has Blackjack");
                System.out.println("Push");
            } else {
                System.out.println("Player loses");
            }
            newDeal();
        }
        Boolean playerBlackjack = false;
        for(Player player : playerList) {
            if (player.isBlackjack()) {
                System.out.println( player.getName() + " has Blackjack");
                playerBlackjack = true;
            }
        }
        if (playerBlackjack){
            newDeal();
        }
    }

    public Boolean checkBust(Players player){
        if(player.getTotal() > 21){
            return true;
        }
        return false;
    }

    public void dealerPlay(){
        while(dealer.getTotal() < 17){
            dealer.addCard(deck.drawCard());
        }
    }

    public void hitStay(){

        for(Player player : playerList) {
            while (true) {
                System.out.println( player.getName() + " has " + player.handString());
                System.out.println("For a total of " + player.getTotal());
                System.out.println("Would you like to hit y or n: ");
                String hitAns = scan.nextLine().toLowerCase();
                if (hitAns.contains("y")) {
                    player.addCard(deck.drawCard());
                    if (checkBust(player)) {
                        System.out.println("Player has busted.");

                        break;
                    }
                } else {
                    break;
                }
            }
        }
        dealerPlay();
        if(checkBust(dealer)){
            System.out.println("Dealer has busted.");
            System.out.println("Player wins");
            return;
        }

        System.out.println("Dealer has " + dealer.hand.toString()+ " for a total " + dealer.getTotal());
        System.out.println("Player has " + player.hand.toString()+ " for a total " + player.getTotal());

        if(checkWin() == dealer){
            System.out.println("Dealer wins this hand");
        } else {
            System.out.println("Player wins this hand");
        }

    }

    public Players checkWin(){
        if(player.getTotal() > dealer.getTotal()){
            return player;
        }
        return dealer;
    }
}
