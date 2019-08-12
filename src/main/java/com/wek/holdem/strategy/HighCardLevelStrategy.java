package com.wek.holdem.strategy;

import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.GroupLevel;
import com.wek.holdem.utils.Pokerutils;

import java.util.Map;

/**
 * 高牌判断类
 * 通过 cardGroup 的 countMap 是否等于 cardSize 判断是否散牌 同时需要不同花色及不连续
 */
public class HighCardLevelStrategy extends AbstractLevelStrategy {
    @Override
    protected GroupLevel doResolve(CardGroup cardGroup) {
        Map<Integer, Integer> cardCountMap = cardGroup.getCardCountMap();
        if (cardCountMap.size() == cardGroup.getCards().size()) {
            if (!Pokerutils.isSameSuit(cardGroup) && !Pokerutils.isSequentialNum(cardGroup)) {
                return GroupLevel.HIGH_CARD;
            }
        }

        return null;
    }

}
