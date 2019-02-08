package com.percyvega.experiments.enumerations;

public enum CurrencyDenomination {

    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private int value;

    private CurrencyDenomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
