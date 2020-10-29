package com.spring.hockeystats;

import java.util.Scanner;

public class Blackjack {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    Scanner scan = new Scanner(System.in);

    public void game(){
        while (true){
            System.out.println("Would you like to play blackjack y or n?: ");
            String ans = scan.nextLine().toLowerCase();
            if (ans.contains("y")){
                setupGame();
                hitStay();
            }
            break;
        }
    }

    public void setupGame(){
        deck = new Deck();
        player = new Player(new Hand());
        dealer = new Dealer(new Hand());
        deck.shuffle();

        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
    }

    public void newDeal(){
        player.clearHand();
        dealer.clearHand();
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
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
        if (player.isBlackjack()){
            System.out.println("Player has Blackjack");
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

        while(true) {
            System.out.println("Player has " + player.handString());
            System.out.println("For a total of " + player.getTotal());
            System.out.println("Would you like to hit y or n: ");
            String hitAns = scan.nextLine().toLowerCase();
            if (hitAns.contains("y")) {
                player.addCard(deck.drawCard());
                if(checkBust(player)){
                    System.out.println("Player has busted.");
                    System.out.println("Dealer wins");
                    return;
                }
            }
            break;
        }
        dealerPlay();
        if(checkBust(dealer)){
            System.out.println("Dealer has busted.");
            System.out.println("Player wins");
            return;
        }

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
