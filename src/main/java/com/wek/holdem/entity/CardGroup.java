package com.wek.holdem.entity;

import com.wek.holdem.cardComparator.CardComparator;
import com.wek.holdem.utils.Pokerutils;

import java.util.*;

public class CardGroup implements Comparable<CardGroup>{
    private List<Card> cards;
    private GroupLevel groupLevel; //牌组的牌型

    public CardGroup addCard(Card card) {
        this.cards.add(card);
        Collections.sort(this.cards);
        return this;
    }


    //统计牌数的出现次数
    public Map<Integer, Integer> getCardCountMap() {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Card card : this.cards) {
            Integer number = card.getCardNumber().getNumber();
            if (countMap.containsKey(number)) {
                countMap.put(number, countMap.get(number) + 1);
            } else {
                countMap.put(number, 1);
            }
        }
        return countMap;
    }

    public CardGroup() {
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public GroupLevel getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(GroupLevel groupLevel) {
        this.groupLevel = groupLevel;
    }

    @Override
    public String toString() {
        return "CardGroup{" +
                "cards=" + cards +
                ", groupLevel=" + groupLevel +
                '}';
    }

    @Override
    public int compareTo(CardGroup o) {
        int self = this.getGroupLevel().getPriority();
        int other = this.getGroupLevel().getPriority();
        if (self < other) {
            return 1;
        }
        if (self > other) {
            return -1;
        }
        if (self == other) {
            CardComparator cardComparator = Pokerutils.cardComparatorMap.get(this.groupLevel);
            return cardComparator.compare(this, o);
        }

        return 0;
    }
}
