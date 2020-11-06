package com.spring.hockeystats;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        ArrayList<Card> hand = new ArrayList<>();
        this.hand = hand;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public int getHandValue(){
        int total = 0;
        for(Card card : hand){
            total += card.getValue();
        }
        return total;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public void clearHand(){
        hand = new ArrayList<Card>();
    }

    @Override
    public String toString() {
        String string = "";
        for(Card card : hand){
            string += card.toString();
            string += " ";
        }
        return string;
    }
}
