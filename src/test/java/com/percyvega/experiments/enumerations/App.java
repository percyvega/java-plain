package com.percyvega.experiments.enumerations;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

    public static void main(String... args) {

        CurrencyDenomination[] denoms = CurrencyDenomination.values();
        for (CurrencyDenomination denom : denoms) {
            log.info(denom.name() + ", " + denom.getValue() + ", " + denom + ", " + denom.ordinal());
        }

        for (CurrencyDenomination denom : denoms) {
            switch (denom) {
                case PENNY:
                    log.info("This is the smallest coin.");
                    break;
                case NICKLE:
                    log.info("This is the second smallest coin.");
                    break;
                case DIME:
                    log.info("This is the second largest coin.");
                    break;
                case QUARTER:
                    log.info("This is the largest coin.");
                    break;
            }

        }

        CurrencyDenomination myDime = CurrencyDenomination.DIME;
        if (myDime == CurrencyDenomination.DIME) {
            log.info("enum in java can be compared using ==");
        }

        Currency[] currencies = Currency.values();
        for (Currency currency : currencies) {
            log.info(currency.name() + ", " + currency.color() + ", " + currency + ", " + currency.ordinal());
        }
    }

}
