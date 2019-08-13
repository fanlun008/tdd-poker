package com.wek.holdem.entity;

import com.wek.holdem.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class CardLevelHandler {

    private static List<ICardLevelStrategy> strategyList = new ArrayList<>();

    public CardLevelHandler() {
        strategyList.add(new TwoPairLevelStrategy());
        strategyList.add(new OnePairLevelStrategy());
        strategyList.add(new HighCardLevelStrategy());
        strategyList.add(new BasicLevelStrategy());
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
