package com.spring.hockeystats;

public interface Players {
    public Boolean isBlackjack();
    public void hit(Card card);
    public int getTotal();
    public void clearHand();
}
