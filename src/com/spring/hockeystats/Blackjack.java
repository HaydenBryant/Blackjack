package com.spring.hockeystats;

import java.util.Scanner;

public class Blackjack {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    Scanner scan = new Scanner(System.in);

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
        if(dealer.getTotal() < 17){

        }
    }

    public void hitStay(){
        System.out.println("Player has " + player.handString());
        System.out.println("For a total of " + player.getTotal());

        while(true) {
            System.out.println("Would you like to hit y or n: ");
            String hitAns = scan.nextLine();
            if (hitAns.contains("y")) {
                player.addCard(deck.drawCard());
                if(checkBust(player)){
                    System.out.println("Player has busted.");
                    break;
                }
            }
            break;
        }

    }
}
