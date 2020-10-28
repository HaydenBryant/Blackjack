package com.spring.hockeystats;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    protected ArrayList<Card> deck;

    public Deck(){
        ArrayList<Card> deck = new ArrayList<>();
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, "H"));
        }
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, "D"));
        }
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, "S"));
        }
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, "C"));
        }
        this.deck = deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        for(Card card : deck){
            System.out.println(card.toString());
        }
        System.out.println("Break");
        return "Done";
    }
}
