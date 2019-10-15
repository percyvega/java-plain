package com.percyvega.experiments.enumerations;

public enum Currency implements Runnable {

    PENNY(1) {
        @Override
        public void run() {
            System.out.println("copper");
        }

        @Override
        public String color() {
            return "copper";
        }
    }, NICKLE(5) {
        @Override
        public void run() {
            System.out.println("bronze");
        }

        @Override
        public String color() {
            return "bronze";
        }
    }, DIME(10) {
        @Override
        public void run() {
            System.out.println("silver");
        }

        @Override
        public String color() {
            return "silver";
        }
    }, QUARTER(25) {
        @Override
        public void run() {
            System.out.println("silver");
        }

        @Override
        public String color() {
            return "silver";
        }
    };

    private int value;

    Currency(int value) {
        this.value = value;
    }

    public abstract String color();

    @Override
    public String toString() {
        String returnString = super.toString();
        switch (this) {
            case PENNY:
                returnString = "Penny: " + value;
                break;
            case NICKLE:
                returnString = "Nickle: " + value;
                break;
            case DIME:
                returnString = "Dime: " + value;
                break;
            case QUARTER:
                returnString = "Quarter: " + value;
                break;
        }
        return returnString;
    }
}
