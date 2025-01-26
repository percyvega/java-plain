package com.percyvega.experiments.puzzles;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppObjectCache {

    /**
     * The Integer type keeps a cache of all objects with a value in the range of -128 to 127 for performance reasons.
     * So when you declare new variables in that range, you’re actually referring to the same object.
     */
    private static void first() {
        Integer a = -129;
        Integer b = -129;
        log.info(a == b);
        Integer c = -128;
        Integer d = -128;
        log.info(c == d);
        Integer e = 127;
        Integer f = 127;
        log.info(e == f);
        Integer g = 128;
        Integer h = 128;
        log.info(g == h);
    }

    public static void main(String[] args) {
        first();
    }

}
