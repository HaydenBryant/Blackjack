package com.spring.hockeystats;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    protected ArrayList<Card> deck;
    protected int iterator = 0;

    public Deck(){
        ArrayList<Card> deck = new ArrayList<>();
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, i, "H"));
        }
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, i, "D"));
        }
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, i, "S"));
        }
        for(int i = 1; i <= 13; i++){
            deck.add(new Card(i, i, "C"));
        }
        this.deck = deck;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Card drawCard(){
        Card card = deck.get(iterator);
        iterator++;
        return card;
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
