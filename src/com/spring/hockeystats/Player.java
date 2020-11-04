package com.spring.hockeystats;

public class Player implements Players{
    protected Hand hand;
    protected String name;

    public Player(Hand hand, String name) {
        this.hand = hand;
        this.name = name;
    }

    @Override
    public Boolean isBlackjack() {
        if(hand.getHandValue() == 21){
            return true;
        }
        return false;
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


    @Override
    public void clearHand() {
        hand.clearHand();
    }

    public String getName(){
        return this.name;
    }
}
