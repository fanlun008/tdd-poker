package com.wek.holdem.entity;

import com.wek.holdem.strategy.HighCardLevelStrategy;
import com.wek.holdem.strategy.ICardLevelStrategy;
import com.wek.holdem.strategy.OnePairLevelStrategy;

import java.util.ArrayList;
import java.util.List;

public class CardLevelHandler {

    private static List<ICardLevelStrategy> strategyList = new ArrayList<>();

    public CardLevelHandler() {
        strategyList.add(new OnePairLevelStrategy());
        strategyList.add(new HighCardLevelStrategy());
    }

    public GroupLevel computeLevel(CardGroup cardGroup) {
        GroupLevel groupLevel = null;
        for (ICardLevelStrategy strategy : strategyList) {
            groupLevel = strategy.resolve(cardGroup);
            if (groupLevel != null) {
                return groupLevel;
            }
        }
        return groupLevel;
    }
}
