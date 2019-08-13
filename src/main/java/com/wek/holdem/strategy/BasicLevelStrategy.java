package com.wek.holdem.strategy;

import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.GroupLevel;

public class BasicLevelStrategy extends AbstractLevelStrategy {
    @Override
    protected GroupLevel doResolve(CardGroup cardGroup) {
        return GroupLevel.HIGH_CARD;
    }
}
