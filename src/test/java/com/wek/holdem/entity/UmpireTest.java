package com.wek.holdem.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UmpireTest {

    @Test
    public void testComputeCardLevel() {
        Umpire umpire = new Umpire();
        Card card1 = new Card(CardNumber.CARD_EIGHT, CardSuit.SPADES);
        Card card2 = new Card(CardNumber.CARD_THREE, CardSuit.HEARTS);
        Card card3 = new Card(CardNumber.CARD_KING, CardSuit.SPADES);
        Card card4 = new Card(CardNumber.CARD_ACE, CardSuit.CLUBS);
        CardGroup cardGroup = new CardGroup();
        cardGroup.addCard(card1).addCard(card2).addCard(card3).addCard(card4);
        Assertions.assertNull(cardGroup.getGroupLevel());
        umpire.addCardGroup(cardGroup);
        umpire.computeCardLevel();
        System.out.println(cardGroup);
        Assertions.assertNotNull(cardGroup.getGroupLevel());
    }

    @Test
    public void testCompareTwoCardGroup() {
        Card card1 = new Card(CardNumber.CARD_THREE, CardSuit.CLUBS);
        Card card2 = new Card(CardNumber.CARD_NINE, CardSuit.SPADES);
        Card card3 = new Card(CardNumber.CARD_KING, CardSuit.HEARTS);

        CardGroup cardGroup1 = new CardGroup();
        cardGroup1.addCard(card1).addCard(card2).addCard(card3);

        Card card4 = new Card(CardNumber.CARD_TWO, CardSuit.HEARTS);
        Card card5 = new Card(CardNumber.CARD_NINE, CardSuit.HEARTS);
        Card card6 = new Card(CardNumber.CARD_EIGHT, CardSuit.SPADES);

        CardGroup cardGroup2 = new CardGroup();
        cardGroup2.addCard(card4).addCard(card5).addCard(card6);

        Umpire umpire = new Umpire();
        String result = umpire.compareTwoCardGroup(cardGroup1, cardGroup2);
        Assertions.assertEquals(cardGroup1.toString()+ ": win", result);
    }

}
