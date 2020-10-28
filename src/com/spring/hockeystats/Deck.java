package com.spring.hockeystats;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    protected ArrayList<Card> deck;

    public Deck(){

        for(int i = 0; i <= 13; i++){
            deck.add(new Card(i, "H"));
        }
        for(int i = 0; i <= 13; i++){
            deck.add(new Card(i, "D"));
        }
        for(int i = 0; i <= 13; i++){
            deck.add(new Card(i, "C"));
        }
        for(int i = 0; i <= 13; i++){
            deck.add(new Card(i, "S"));
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
}
