package com.wek.holdem.entity;

import com.wek.holdem.utils.Pokerutils;

import java.util.ArrayList;
import java.util.List;

/**
 * 裁判类
 */
public class Umpire {
    private CardLevelHandler cardLevelHandler = new CardLevelHandler();
    private List<CardGroup> cardGroupList = new ArrayList<>();

    public void addCardGroup(CardGroup cardGroup) {
        this.cardGroupList.add(cardGroup);
    }

    public void computeCardLevel() {
        for (CardGroup cardGroup : this.cardGroupList) {
            cardLevelHandler.computeLevel(cardGroup);
        }
    }

    public String compareTwoCardGroup(CardGroup cardGroup1, CardGroup cardGroup2) {
        Pokerutils.computeLevel(cardGroup1);
        Pokerutils.computeLevel(cardGroup2);
        if (cardGroup1.compareTo(cardGroup2) < 0) {
            return cardGroup1 +": win";
        }
        if (cardGroup1.compareTo(cardGroup2) > 0) {
            return cardGroup2 + ": win";
        }
        return "dogfall";
    }


}
