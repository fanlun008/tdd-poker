package com.wek.holdem.strategy;

import com.wek.holdem.entity.*;
import com.wek.holdem.utils.Pokerutils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOnePairLevelStrategy {

    @Test
    public void test_given_twoSameCard_then_getOnePairLevel() {
        //given
        Card card1 = new Card(CardNumber.CARD_THREE, CardSuit.CLUBS);
        Card card2 = new Card(CardNumber.CARD_NINE, CardSuit.SPADES);
        Card card3 = new Card(CardNumber.CARD_KING, CardSuit.HEARTS);
        Card card4 = new Card(CardNumber.CARD_NINE, CardSuit.HEARTS);

        CardGroup cardGroup = new CardGroup();
        cardGroup.addCard(card1).addCard(card2).addCard(card3).addCard(card4);

        //when
        Pokerutils.computeLevel(cardGroup);

        //then
        Assertions.assertEquals(GroupLevel.ONE_PAIR, cardGroup.getGroupLevel());
        Assertions.assertSame(2, cardGroup.getCardCountMap().get(CardNumber.CARD_NINE.getNumber()));
    }
}
