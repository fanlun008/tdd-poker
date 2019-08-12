package com.wek.holdem.entity;

import lombok.Getter;
import lombok.Setter;

public enum CardSuit {
    HEARTS("H"),
    DIAMONDS("D"),
    SPADES("S"),
    CLUBS("C");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    CardSuit(String name) {
        this.name = name;
    }
}
