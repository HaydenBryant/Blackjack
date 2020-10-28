package com.spring.hockeystats;
import com.spring.hockeystats.Deck;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Deck deck = new Deck();

        deck.toString();
        deck.shuffle();
        deck.toString();
    }
}
