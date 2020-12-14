package com.percyvega.experiments.puzzles;

import lombok.extern.log4j.Log4j2;

/**
 * The equals method evaluates logical values, while == evaluates if both references point to the same object.
 *      2020-12-13 15:06:06,026657 INFO [main] 128 != 128
 *      2020-12-13 15:06:06,028457 INFO [main] 129 != 129
 *      2020-12-13 15:06:06,028562 INFO [main] 130 != 130
 */
@Log4j2
public class EqualsVsExample {

    public static void main(String[] args) {
        for (int i = 0; i <= 130; i++) {
            Integer i1 = i;
            Integer i2 = i;

            if(!i1.equals(i2)) {
                log.info("{} not equals {}", i1, i2);
            }

            if(i1 != i2) {
                log.info("{} != {}", i1, i2);
            }
        }
    }

}
