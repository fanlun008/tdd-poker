package com.wek.holdem.utils;

import com.wek.holdem.cardComparator.CardComparator;
import com.wek.holdem.cardComparator.HighCardComparator;
import com.wek.holdem.cardComparator.OnePairComparator;
import com.wek.holdem.entity.Card;
import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.CardLevelHandler;
import com.wek.holdem.entity.GroupLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pokerutils {
    public static final int STANDARD_CARD_NUM = 5;
    public final static Map<GroupLevel, CardComparator> cardComparatorMap = new HashMap<>();
    public final static CardLevelHandler cardLevelHandler = new CardLevelHandler();

    static {
        cardComparatorMap.put(GroupLevel.HIGH_CARD, new HighCardComparator());
        cardComparatorMap.put(GroupLevel.ONE_PAIR, new OnePairComparator());
    }

    public static void computeLevel(CardGroup cardGroup) {
        cardLevelHandler.computeLevel(cardGroup);
    }

    public static boolean isSameSuit(CardGroup cardGroup) {
        List<Card> cards = cardGroup.getCards();
        if (cards == null || cards.size() == 0) {
            return false;
        }
        if (cards.size() == 1) {
            return true;
        }
        String standardSuit = cards.get(0).getCardSuit().getName();
        for (int i =1; i< cards.size(); i++) {
            if (!(cards.get(i).getCardSuit().getName().equals(standardSuit))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSequentialNum(CardGroup cardGroup) {
        List<Card> cards = cardGroup.getCards();
        if (cards == null || cards.size() <= 2) {
            return false;
        }
        Integer maxNum = cards.get(0).getCardNumber().getNumber();
        Integer minNum = cards.get(cards.size() - 1).getCardNumber().getNumber();
        if (maxNum - minNum == cardGroup.getCards().size()) {  //***
            return true;
        }
        return false;
    }
}
