package com.wek.holdem.entity;

public enum GroupLevel {
    HIGH_CARD("高牌", 1),
    ONE_PAIR("一对", 2),
    TWO_PAIR("两对", 3),
    THREE_OF_THE_KIND("三条", 4),
    STRAIGHT("顺子", 5),
    FLUSH("同花", 6),
    FULL_HOUSE("葫芦", 7),
    FOUR_OF_THE_KIND("四条", 8),
    STRAIGHT_FLUSH("同花顺", 9),
    ROYAL_FLUSH("皇家同花顺", 1);

    private String type;
    private int priority;

    GroupLevel(String type, int priority) {
        this.type = type;
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
