package com.wek.holdem.entity;

import lombok.Getter;
import lombok.Setter;

public enum CardNumber {
    CARD_TWO(2),
    CARD_THREE(3),
    CARD_FOUR(4),
    CARD_FIVE(5),
    CARD_SIX(6),
    CARD_SEVEN(7),
    CARD_EIGHT(8),
    CARD_NINE(9),
    CARD_TEN(10),
    CARD_JACK(11),
    CARD_QUEUE(12),
    CARD_KING(13),
    CARD_ACE(14);

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    CardNumber(Integer number) {
        this.number = number;
    }
}
