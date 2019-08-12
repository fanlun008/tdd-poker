package com.wek.holdem.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardGroupTest {
    @Test
    public void testAdd2Card_givenCard_whenAddCard_thenReturn2Size() {
        //given
        Card card1 = new Card(CardNumber.CARD_NINE, CardSuit.HEARTS);
        Card card2 = new Card(CardNumber.CARD_EIGHT, CardSuit.SPADES);
        CardGroup cardGroup = new CardGroup();

        //when
        cardGroup.addCard(card1).addCard(card2);
        Assertions.assertSame(2, cardGroup.getCards().size());
    }
}
