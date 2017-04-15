package com.percyvega.experiments.bits_bytes;

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
public class AppInt {

    private static final Logger logger = LoggerFactory.getLogger(AppInt.class);

    // java int: 32-bit signed two's complement integer. -2,147,483,648 <= x <= 2,147,483,647
    public static void main(String[] args) {

        int maxIntBin = 0b0111_1111_1111_1111_1111_1111_1111_1111; // maximum value for an int in hex
        logger.debug("0b0111_1111_1111_1111_1111_1111_1111_1111 (bin): " + String.format("%32s", Integer.toBinaryString(maxIntBin)).replace(' ', '0'));
        logger.debug("0b0111_1111_1111_1111_1111_1111_1111_1111 (oct): " + String.format("%16s", Integer.toOctalString(maxIntBin)).replace(' ', '0'));
        logger.debug("0b0111_1111_1111_1111_1111_1111_1111_1111 (hex): " + String.format("%8s", Integer.toHexString(maxIntBin)).replace(' ', '0'));
        logger.debug("0b0111_1111_1111_1111_1111_1111_1111_1111 (dec): " + Integer.parseInt(Integer.toBinaryString(maxIntBin), 2)); // maxIntBin

        System.out.println();

        int minIntBin = 0b1000_0000_0000_0000_0000_0000_0000_0000; // minimum value for an int in bin
        logger.debug("0b1000_0000_0000_0000_0000_0000_0000_0000 (bin): " + String.format("%32s", Integer.toBinaryString(minIntBin)).replace(' ', '0'));
        logger.debug("0b1000_0000_0000_0000_0000_0000_0000_0000 (oct): " + String.format("%16s", Integer.toOctalString(minIntBin)).replace(' ', '0'));
        logger.debug("0b1000_0000_0000_0000_0000_0000_0000_0000 (hex): " + String.format("%8s", Integer.toHexString(minIntBin)).replace(' ', '0'));
        logger.debug("0b1000_0000_0000_0000_0000_0000_0000_0000 (dec): " + minIntBin); // Exception when using: Integer.parseInt(Integer.toBinaryString(minIntBin), 2)) because 32nd bit is 1. Needs complement.

        System.out.println();

        int maxIntHex = 0x7FFFFFFF; // maximum value for an int in hex
        logger.debug("0x7FFFFFFF (bin): " + String.format("%32s", Integer.toBinaryString(maxIntHex)).replace(' ', '0'));
        logger.debug("0x7FFFFFFF (oct): " + String.format("%8s", Integer.toOctalString(maxIntHex)).replace(' ', '0'));
        logger.debug("0x7FFFFFFF (hex): " + String.format("%2s", Integer.toHexString(maxIntHex)).replace(' ', '0'));
        logger.debug("0x7FFFFFFF (dec): " + Integer.parseInt(Integer.toHexString(maxIntHex), 16)); // maxIntHex

        System.out.println();

        int minIntHex = 0x80000000; // minimum value for an int in hex
        logger.debug("0xF0000000 (bin): " + String.format("%32s", Integer.toBinaryString(minIntHex)).replace(' ', '0'));
        logger.debug("0xF0000000 (oct): " + String.format("%8s", Integer.toOctalString(minIntHex)).replace(' ', '0'));
        logger.debug("0xF0000000 (hex): " + String.format("%2s", Integer.toHexString(minIntHex)).replace(' ', '0'));
        logger.debug("0xF0000000 (dec): " + minIntHex); // Exception when using: Integer.parseInt(Integer.toHexString(minIntHex), 16)) because 32nd bit is 1. Needs complement.

    }
}
