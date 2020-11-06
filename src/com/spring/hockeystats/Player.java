package com.spring.hockeystats;

import java.util.ArrayList;

public class Player implements Players{
    private Hand hand;
    private String name;
    private Boolean busted;

    public Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
        this.busted = false;
    }

    @Override
    public Boolean isBlackjack() {
        if(hand.getHandValue() == 21){
            return true;
        }
        return false;
    }

    public Boolean getBusted(){
        return this.busted;
    }

    public void setBusted(Boolean busted){
        this.busted = busted;
    }

    @Override
    public void addCard(Card card) {
        hand.addCard(card);
    }

    public String handString(){
        String string = hand.toString();
        return string;
    }

    @Override
    public int getTotal() {
        return hand.getHandValue();
    }

    public ArrayList<Card> getHand(){
        return hand.getHand();
    }

    @Override
    public void clearHand() {
        hand.clearHand();
    }

    public String getName(){
        return this.name;
    }
}
