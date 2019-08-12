package com.wek.holdem.entity;

public class Card implements Comparable<Card>{

    private CardNumber cardNumber;
    private CardSuit cardSuit;

    public Card(CardNumber cardNumber, CardSuit cardSuit) {
        this.cardNumber = cardNumber;
        this.cardSuit = cardSuit;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        if (this.cardSuit.getName() != card.cardSuit.getName()) return false;
        return this.cardNumber.getNumber() == card.cardNumber.getNumber();
    }

    @Override
    public int hashCode() {
        return this.cardSuit.ordinal() + this.cardNumber.getNumber();
    }

    @Override
    public String toString() {
        return cardNumber.getNumber() + this.cardSuit.getName();
    }

    @Override
    public int compareTo(Card o) {
        int selfNum = this.cardNumber.getNumber();
        int otherNum = o.cardNumber.getNumber();

        if (selfNum < otherNum) {
            return 1;
        }
        if (selfNum > otherNum) {
            return -1;
        }
        return 0;
    }
}
