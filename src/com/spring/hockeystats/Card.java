package com.spring.hockeystats;

public class Card {
    protected int value;
    protected String suit;

    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
