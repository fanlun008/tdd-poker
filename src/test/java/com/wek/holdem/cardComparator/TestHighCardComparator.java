package com.wek.holdem.cardComparator;

import com.wek.holdem.entity.Card;
import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.CardNumber;
import com.wek.holdem.entity.CardSuit;
import com.wek.holdem.utils.Pokerutils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHighCardComparator {

    @Test
    public void testHighCardComparator() {
        Card card1 = new Card(CardNumber.CARD_THREE, CardSuit.CLUBS);
        Card card2 = new Card(CardNumber.CARD_SEVEN, CardSuit.SPADES);
        Card card3 = new Card(CardNumber.CARD_NINE, CardSuit.HEARTS);

        CardGroup cardGroup1 = new CardGroup();
        cardGroup1.addCard(card1).addCard(card2).addCard(card3);
        Pokerutils.computeLevel(cardGroup1);

        Card card4 = new Card(CardNumber.CARD_TWO, CardSuit.HEARTS);
        Card card5 = new Card(CardNumber.CARD_NINE, CardSuit.HEARTS);
        Card card6 = new Card(CardNumber.CARD_EIGHT, CardSuit.SPADES);

        CardGroup cardGroup2 = new CardGroup();
        cardGroup2.addCard(card4).addCard(card5).addCard(card6);
        Pokerutils.computeLevel(cardGroup2);

        List<CardGroup> list = new ArrayList<>();
        list.add(cardGroup1);
        list.add(cardGroup2);

        Collections.sort(list);
        for (CardGroup item: list) {
            System.out.println(item);
        }

        Assertions.assertEquals(cardGroup2, list.get(0));
        Assertions.assertEquals(cardGroup1, list.get(1));
    }
}
