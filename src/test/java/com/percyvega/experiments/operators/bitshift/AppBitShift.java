package com.percyvega.experiments.operators.bitshift;

import lombok.extern.log4j.Log4j2;

@Log4j2
/**
 * Copyright 2015 Percy Vega
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AppBitShift {


    public static void main(String[] args) {

        int firstInt = 0b0010_0101_0101_0101_0101_0011_1010_1111;
        int secondInt = 0b1101_1111_0001_0101_0000_0101_0101_0000;

        log.debug(getBinString(firstInt) + " is   " + firstInt + " before << (Signed left shift)");
        log.debug(getBinString(firstInt << 1) + " is  " + (firstInt << 1) + " after << 1");
        log.debug(getBinString(firstInt << 2) + " is " + (firstInt << 2) + " after << 2");
        log.debug(getBinString(firstInt << 3) + " is   " + (firstInt << 3) + " after << 3");

        System.out.println();

        log.debug(getBinString(secondInt) + " is  " + secondInt + " before << (Signed left shift)");
        log.debug(getBinString(secondInt << 1) + " is " + (secondInt << 1) + " after << 1");
        log.debug(getBinString(secondInt << 2) + " is  " + (secondInt << 2) + " after << 2");
        log.debug(getBinString(secondInt << 3) + " is  " + (secondInt << 3) + " after << 3");

        System.out.println();

        log.debug(getBinString(firstInt) + " is   " + firstInt + " before >> (Signed right shift)");
        log.debug(getBinString(firstInt >> 1) + " is   " + (firstInt >> 1) + " after >> 1");
        log.debug(getBinString(firstInt >> 2) + " is   " + (firstInt >> 2) + " after >> 2");
        log.debug(getBinString(firstInt >> 3) + " is    " + (firstInt >> 3) + " after >> 3");

        System.out.println();

        log.debug(getBinString(secondInt) + " is  " + secondInt + " before >> (Signed right shift)");
        log.debug(getBinString(secondInt >> 1) + " is  " + (secondInt >> 1) + " after >> 1");
        log.debug(getBinString(secondInt >> 2) + " is  " + (secondInt >> 2) + " after >> 2");
        log.debug(getBinString(secondInt >> 3) + " is   " + (secondInt >> 3) + " after >> 3");

        System.out.println();

        log.debug(getBinString(firstInt) + " is   " + firstInt + " before >>> (Unsigned right shift)");
        log.debug(getBinString(firstInt >>> 1) + " is   " + (firstInt >>> 1) + " after >>> 1");
        log.debug(getBinString(firstInt >>> 2) + " is   " + (firstInt >>> 2) + " after >>> 2");
        log.debug(getBinString(firstInt >>> 3) + " is    " + (firstInt >>> 3) + " after >>> 3");

        System.out.println();

        log.debug(getBinString(secondInt) + " is  " + secondInt + " before >>> (Unsigned right shift)");
        log.debug(getBinString(secondInt >>> 1) + " is  " + (secondInt >>> 1) + " after >>> 1");
        log.debug(getBinString(secondInt >>> 2) + " is   " + (secondInt >>> 2) + " after >>> 2");
        log.debug(getBinString(secondInt >>> 3) + " is   " + (secondInt >>> 3) + " after >>> 3");

    }

    private static String getBinString(int intDec) {
        return String.format("%32s", Integer.toBinaryString(intDec)).replace(' ', '0');
    }
}
