package com.wek.holdem.cardComparator;

import com.wek.holdem.entity.Card;
import com.wek.holdem.entity.CardGroup;

import java.util.List;

public class HighCardComparator implements CardComparator{

    @Override
    public int compare(CardGroup group1, CardGroup group2) {
        List<Card> cards1 = group1.getCards();
        List<Card> cards2 = group2.getCards();

        for (int i = 0; i< cards1.size(); i++) {
            if (cards1.get(i).getCardNumber().getNumber() < cards2.get(i).getCardNumber().getNumber()) {
                return 1;
            }
            if (cards1.get(i).getCardNumber().getNumber() > cards2.get(i).getCardNumber().getNumber()) {
                return -1;
            }
            if (cards1.get(i).getCardNumber().getNumber() == cards2.get(i).getCardNumber().getNumber()) {
                continue;
            }
        }
        return 0;

    }
}
