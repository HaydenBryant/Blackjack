package com.spring.hockeystats;

public interface Players {
    public Boolean isBlackjack();
    public void addCard(Card card);
    public int getTotal();
    public void clearHand();
}
