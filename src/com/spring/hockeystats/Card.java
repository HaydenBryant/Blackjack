package com.spring.hockeystats;

public class Card {
    protected int value;
    protected int number;
    protected String suit;

    public Card(int value, int number, String suit){
        this.suit = suit;
        this.number = number;

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
        if(number > 10 || number == 1){
            switch (number){
                case 11:
                    return "J of " + suit;
                case 12:
                    return "Q of " + suit;
                case 13:
                    return "K of " + suit;
                case 1:
                    return "A of " + suit;
            }
        }
        return number + " of " + suit;
    }
}
