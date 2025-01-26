package com.percyvega.experiments.operators.modulus;

import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 2/4/2016.
 */
@Log4j2
public class AppModulus {

    public static void main(String[] args) {

        for (int i = 0; i <= 30; i += 3) {
            log.info(i + " % 5 = " + i % 5);
        }

    }

}
