package com.percyvega.experiments.operators.bitwise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppBitwise {

    private static final Logger logger = LoggerFactory.getLogger(AppBitwise.class);

    public static void main(String[] args) {

        int firstInt = 0b0101_0011_1010_1111;
        int secondInt = 0b0000_0101_0101_0000;

        logger.debug(getBinString(firstInt) + " is " + firstInt);
        logger.debug(getBinString(~firstInt) + " is " + (~firstInt) + " after ~ (Unary bitwise complement)");

        System.out.println();

        logger.debug(getBinString(firstInt) + " is " + firstInt);
        logger.debug(getBinString(secondInt) + " is  " + secondInt);
        logger.debug(getBinString(firstInt & secondInt) + " is   " + (firstInt & secondInt) + " after & (Bitwise AND)");

        System.out.println();

        logger.debug(getBinString(firstInt) + " is " + firstInt);
        logger.debug(getBinString(secondInt) + " is  " + secondInt);
        logger.debug(getBinString(firstInt | secondInt) + " is " + (firstInt | secondInt) + " after | (Bitwise inclusive OR)");

        System.out.println();

        logger.debug(getBinString(firstInt) + " is " + firstInt);
        logger.debug(getBinString(secondInt) + " is  " + secondInt);
        logger.debug(getBinString(firstInt ^ secondInt) + " is " + (firstInt ^ secondInt) + " after ^ (Bitwise exclusive OR)");

    }

    private static String getBinString(int intDec) {
        return String.format("%32s", Integer.toBinaryString(intDec)).replace(' ', '0');
    }
}
