package com.wek.holdem.strategy;

import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.GroupLevel;

import java.util.Map;

public class TwoPairLevelStrategy extends AbstractLevelStrategy {
    @Override
    protected GroupLevel doResolve(CardGroup cardGroup) {
        Map<Integer, Integer> cardCountMap = cardGroup.getCardCountMap();
        if (cardGroup.getCards().size() <= 3) {
            return null;
        }
        if (cardCountMap.size() == cardGroup.getCards().size() - 2) {
            for (Map.Entry<Integer, Integer> entry : cardCountMap.entrySet()) {
                if (entry.getValue() == 2 || entry.getValue() == 1) {
                    continue;
                } else {
                    return null;
                }
            }
            return GroupLevel.TWO_PAIR;
        } else {
            return null;
        }
    }
}
