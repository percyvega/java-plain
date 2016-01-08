package com.percyvega.experiments.enumerations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {

        CurrencyDenomination[] denoms = CurrencyDenomination.values();
        for (CurrencyDenomination denom : denoms) {
            logger.debug(denom.name() + ", " + denom.getValue() + ", " + denom.toString() + ", " + denom.ordinal());
        }

        for (CurrencyDenomination denom : denoms) {
            switch (denom) {
                case PENNY:
                    logger.debug("This is the smallest coin.");
                    break;
                case NICKLE:
                    logger.debug("This is the second smallest coin.");
                    break;
                case DIME:
                    logger.debug("This is the second largest coin.");
                    break;
                case QUARTER:
                    logger.debug("This is the largest coin.");
                    break;
            }

        }

        CurrencyDenomination myDime = CurrencyDenomination.DIME;
        if (myDime == CurrencyDenomination.DIME) {
            logger.debug("enum in java can be compared using ==");
        }

        Currency[] currencies = Currency.values();
        for (Currency currency : currencies) {
            logger.debug(currency.name() + ", " + currency.color() + ", " + currency.toString() + ", " + currency.ordinal());
        }
    }

}
