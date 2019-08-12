package com.wek.holdem.strategy;

import com.wek.holdem.entity.*;
import com.wek.holdem.utils.Pokerutils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTwoPairLevelStrategy {
    @Test
    public void test_givenACardGroup_thenReturnTwoPair() {
        Card card1 = new Card(CardNumber.CARD_THREE, CardSuit.CLUBS);
        Card card2 = new Card(CardNumber.CARD_NINE, CardSuit.SPADES);
        Card card3 = new Card(CardNumber.CARD_KING, CardSuit.HEARTS);
        Card card4 = new Card(CardNumber.CARD_NINE, CardSuit.HEARTS);
        Card card5 = new Card(CardNumber.CARD_KING, CardSuit.CLUBS);

        CardGroup cardGroup = new CardGroup();
        cardGroup.addCard(card1).addCard(card2).addCard(card3).addCard(card4).addCard(card5);

        //when
        Pokerutils.computeLevel(cardGroup);
        Assertions.assertEquals(GroupLevel.TWO_PAIR, cardGroup.getGroupLevel());
    }
}
