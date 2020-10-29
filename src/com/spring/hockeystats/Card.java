package com.spring.hockeystats;

public class Card {
    protected int value;
    protected String suit;

    public Card(int value, String suit){
        this.suit = suit;

        if(value > 10){
            this.value = 10;
        } else {
            this.value = value;
        }
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
