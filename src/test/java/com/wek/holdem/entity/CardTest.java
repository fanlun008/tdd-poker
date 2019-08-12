package com.wek.holdem.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest {

    @Test
    public void testCardEqual() {
        Card card1 = new Card(CardNumber.CARD_TWO, CardSuit.CLUBS);
        Card card2 = new Card(CardNumber.CARD_TWO, CardSuit.CLUBS);
        Card card3 = new Card(CardNumber.CARD_THREE, CardSuit.CLUBS);

        Assertions.assertEquals(card1, card2);
        Assertions.assertFalse(card1 == card3);
    }

    @Test
    public void testCardSort() {
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card(CardNumber.CARD_KING, CardSuit.CLUBS);
        Card card2 = new Card(CardNumber.CARD_THREE, CardSuit.HEARTS);
        Card card3 = new Card(CardNumber.CARD_EIGHT, CardSuit.SPADES);
        Card card4 = new Card(CardNumber.CARD_EIGHT, CardSuit.DIAMONDS);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        Collections.sort(cards);
        System.out.println(cards);
        Assertions.assertEquals(card1, cards.get(0));
        Assertions.assertEquals(card3, cards.get(1));
        Assertions.assertEquals(card4, cards.get(2));
        Assertions.assertEquals(card2, cards.get(3));
    }
}
