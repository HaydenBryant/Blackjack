package com.spring.hockeystats;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private ArrayList<Player> playerList;
    Scanner scan = new Scanner(System.in);

    public void game() {
        setupGame();
        if (!checkBlackjack()) {
            for (Player player : playerList) {
                hitStay(player);
            }
        }
        dealerPlay();
        findWinner();
        while (true) {
            System.out.println("Would you like to play again y or n?: ");
            String ans = scan.nextLine().toLowerCase();
            if (ans.contains("y")) {
                newDeal();
                if (checkBlackjack()) {
                    continue;
                }
                for (Player player : playerList) {
                    hitStay(player);
                }
                dealerPlay();
                findWinner();
            } else {
                break;
            }
        }
    }

    public void setupGame() {
        deck = new Deck();
        generatePlayers();
        dealer = new Dealer(new Hand());
        deck.shuffle();
        for (Player player : playerList) {
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
        }
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
        while (true) {
            System.out.println("Would you like to add another player y or n?");
            addPlayer = scan.nextLine();
            if (addPlayer.toLowerCase().contains("y")) {
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

    public void newDeal() {
        if (deck.getIterator() < 26) {
            deck.shuffle();
            System.out.println("New shuffle");
        }

        dealer.clearHand();
        dealer.busted = false;
        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        for (Player player : playerList) {
            player.clearHand();
            player.busted = false;
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
        }
    }

    public Boolean checkBlackjack() {
        Boolean dealerBlackjack = false;
        if (dealer.isBlackjack()) {
            System.out.println("Dealer has Blackjack");
            dealerBlackjack = true;
        }

        Boolean playerBlackjack = false;
        for (Player player : playerList) {
            if (player.isBlackjack()) {
                System.out.println(player.getName() + " has Blackjack");
                playerBlackjack = true;
            }
        }

        if (playerBlackjack && dealerBlackjack) {
            System.out.println("Push");
            return true;
        }
        if (playerBlackjack) {
            return true;
        }
        return false;
    }

    public Boolean checkBust(Players player) {
        if (player.getTotal() > 21) {
            return true;
        }
        return false;
    }

    public void dealerPlay() {
        System.out.println("Dealers turn");
        while (dealer.getTotal() < 17) {
            System.out.println("Dealer hits");
            dealer.addCard(deck.drawCard());
        }
        if (checkBust(dealer)) {
            System.out.println("Dealer has busted.");
            dealer.busted = true;
        }
    }

    public void hitStay(Player player) {
        if (checkBust(player)) {
            handleAce(player);
        }
        while (true) {
            System.out.println(player.getName() + " has " + player.handString());
            System.out.println("For a total of " + player.getTotal());
            System.out.println("Would you like to hit y or n: ");
            String hitAns = scan.nextLine().toLowerCase();
            if (hitAns.contains("y")) {
                player.addCard(deck.drawCard());
                if (checkBust(player)) {
                    if (!aceCheck(player)) {
                        System.out.println(player.getName() + " has busted");
                        player.busted = true;
                        return;
                    } else {
                        handleAce(player);
                        if (checkBust(player)) {
                            System.out.println(player.getName() + " has busted");
                            player.busted = true;
                            return;
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            } else {
                return;
            }
        }
    }

    public void findWinner() {
        ArrayList<Player> winnerList = new ArrayList<>();
        int bestHand = playerList.get(0).getTotal();
        for (Player player : playerList) {
            if (player.getBusted()) {
                continue;
            }
            System.out.println(player.getName() + " has " + player.handString() + " for a total of " + player.getTotal());
            if (player.getTotal() > bestHand) {
                bestHand = player.getTotal();
                winnerList.clear();
                winnerList.add(player);
                continue;
            }
            if (player.getTotal() == bestHand) {
                winnerList.add(player);
                continue;
            }
        }

        if (!dealer.getBusted()) {
            System.out.println("Dealers hand is " + dealer.handString() + " for a total of " + dealer.getTotal());
            if (dealer.getTotal() >= bestHand) {
                System.out.println("Dealer has the best hand");
                return;
            }
        }
        for (Player player : winnerList) {
            System.out.println(player.getName() + " wins this hand with " + bestHand);
        }
    }

    public Boolean aceCheck(Player player) {
        for (Card card : player.hand.hand) {
            if (card.getNumber() == 1) {
                return true;
            }
        }
        return false;
    }

    public void handleAce(Player player) {
        for (Card card : player.hand.hand) {
            if (card.getNumber() == 1 && card.value != 1) {
                card.value = 1;
                break;
            }
        }
    }

}
