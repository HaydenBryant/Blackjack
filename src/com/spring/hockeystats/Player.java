package com.spring.hockeystats;

public class Player implements Players{
    protected Hand hand;


    @Override
    public Boolean isBlackjack() {
        if(hand.getHandValue() == 21){
            return true;
        }
        return false;
    }


    @Override
    public void hit(Card card) {
        hand.addCard(card);
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
