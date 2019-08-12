package com.wek.holdem.strategy;

import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.GroupLevel;

import java.util.Map;

/**
 * 只有一对的牌型
 */
public class OnePairLevelStrategy extends AbstractLevelStrategy {
    @Override
    protected GroupLevel doResolve(CardGroup cardGroup) {
        Map<Integer, Integer> cardCountMap = cardGroup.getCardCountMap();
        if (cardCountMap.size() == cardGroup.getCards().size()-1) {
            for (Map.Entry<Integer, Integer> entry : cardCountMap.entrySet()) {
                if (entry.getValue()==2||entry.getValue()==1) {
                    continue;
                } else {
                    return null;
                }
            }
        }
        return GroupLevel.ONE_PAIR;
    }
}
