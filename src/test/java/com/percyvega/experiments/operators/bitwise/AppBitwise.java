package com.percyvega.experiments.operators.bitwise;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppBitwise {


    public static void main(String[] args) {

        int firstInt = 0b0101_0011_1010_1111;
        int secondInt = 0b0000_0101_0101_0000;

        log.debug(getBinString(firstInt) + " is " + firstInt);
        log.debug(getBinString(~firstInt) + " is " + (~firstInt) + " after ~ (Unary bitwise complement)");

        System.out.println();

        log.debug(getBinString(firstInt) + " is " + firstInt);
        log.debug(getBinString(secondInt) + " is  " + secondInt);
        log.debug(getBinString(firstInt & secondInt) + " is   " + (firstInt & secondInt) + " after & (Bitwise AND)");

        System.out.println();

        log.debug(getBinString(firstInt) + " is " + firstInt);
        log.debug(getBinString(secondInt) + " is  " + secondInt);
        log.debug(getBinString(firstInt | secondInt) + " is " + (firstInt | secondInt) + " after | (Bitwise inclusive OR)");

        System.out.println();

        log.debug(getBinString(firstInt) + " is " + firstInt);
        log.debug(getBinString(secondInt) + " is  " + secondInt);
        log.debug(getBinString(firstInt ^ secondInt) + " is " + (firstInt ^ secondInt) + " after ^ (Bitwise exclusive OR)");

    }

    private static String getBinString(int intDec) {
        return String.format("%32s", Integer.toBinaryString(intDec)).replace(' ', '0');
    }
}
