package com.spring.hockeystats;

public class Dealer implements Players{
    protected Hand hand;

    public Dealer(Hand hand) {
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

    @Override
    public int getTotal() {
        return hand.getHandValue();
    }

    @Override
    public void clearHand() {
        hand.clearHand();
    }
}
