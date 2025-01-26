package com.percyvega.experiments.operators.bitwise;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppBitwise {


    public static void main(String[] args) {

        int firstInt = 0b0101_0011_1010_1111;
        int secondInt = 0b0000_0101_0101_0000;

        log.info(getBinString(firstInt) + " is " + firstInt);
        log.info(getBinString(~firstInt) + " is " + (~firstInt) + " after ~ (Unary bitwise complement)");

        log.info(getBinString(firstInt) + " is " + firstInt);
        log.info(getBinString(secondInt) + " is  " + secondInt);
        log.info(getBinString(firstInt & secondInt) + " is   " + (firstInt & secondInt) + " after & (Bitwise AND)");

        log.info(getBinString(firstInt) + " is " + firstInt);
        log.info(getBinString(secondInt) + " is  " + secondInt);
        log.info(getBinString(firstInt | secondInt) + " is " + (firstInt | secondInt) + " after | (Bitwise inclusive OR)");

        log.info(getBinString(firstInt) + " is " + firstInt);
        log.info(getBinString(secondInt) + " is  " + secondInt);
        log.info(getBinString(firstInt ^ secondInt) + " is " + (firstInt ^ secondInt) + " after ^ (Bitwise exclusive OR)");
    }

    private static String getBinString(int intDec) {
        return String.format("%32s", Integer.toBinaryString(intDec)).replace(' ', '0');
    }
}
