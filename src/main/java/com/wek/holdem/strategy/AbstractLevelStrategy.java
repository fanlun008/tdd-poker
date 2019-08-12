package com.wek.holdem.strategy;

import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.GroupLevel;

public abstract class AbstractLevelStrategy implements ICardLevelStrategy{

    @Override
    public GroupLevel resolve(CardGroup cardGroup) {
        GroupLevel result = doResolve(cardGroup);
        postResolve(cardGroup, result);
        return result;
    }

    protected abstract GroupLevel doResolve(CardGroup cardGroup);

    private void postResolve(CardGroup cardGroup, GroupLevel result) {
        cardGroup.setGroupLevel(result);
    }
}
