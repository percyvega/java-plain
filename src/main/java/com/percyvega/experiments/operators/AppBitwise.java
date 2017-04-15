package com.percyvega.experiments.operators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
