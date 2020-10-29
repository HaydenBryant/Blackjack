package com.spring.hockeystats;

public class Player implements Players{
    protected Hand hand;

    public Player(Hand hand) {
        this.hand = hand;
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
}
