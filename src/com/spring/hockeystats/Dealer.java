package com.spring.hockeystats;

public class Dealer implements Players{
    private Hand hand;
    private Boolean busted;

    public Dealer(Hand hand) {
        this.hand = hand;
        this.busted = false;
    }

    public Boolean getBusted(){
        return busted;
    }

    public void setBusted(Boolean busted){
        this.busted = busted;
    }

    @Override
    public Boolean isBlackjack() {
        if(hand.getHandValue() == 21){
            return true;
        }
        return false;
    }

    public String handString(){
        String string = hand.toString();
        return string;
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
