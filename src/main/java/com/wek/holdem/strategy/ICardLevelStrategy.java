package com.wek.holdem.strategy;

import com.wek.holdem.entity.CardGroup;
import com.wek.holdem.entity.GroupLevel;

public interface ICardLevelStrategy {
    GroupLevel resolve(CardGroup cardGroup);
}
