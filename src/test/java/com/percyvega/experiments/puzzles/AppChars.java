package com.percyvega.experiments.puzzles;

import lombok.extern.log4j.Log4j2;

import java.util.Random;

@Log4j2
public class AppChars {


    private static void first() {
        int cap = 'P';
        log.info(String.valueOf(cap));

        StringBuffer word = new StringBuffer('P');
        int randomInt = new Random().nextInt(2);
        log.info(String.valueOf(randomInt));

        log.info("word: " + word);
        switch (randomInt) {
            case 1:
                word = new StringBuffer('P');
                log.info("inside " + randomInt);
                log.info("word: " + word);
                break;
            case 2:
                word = new StringBuffer('G');
                log.info("inside " + randomInt);
                log.info("word: " + word);
                break;
            default:
                word = new StringBuffer('M');
                log.info("inside " + randomInt);
                log.info("word: " + word);
                break;
        }
        log.info("word: " + word);

        word.append('a');
        word.append('i');
        word.append('n');
        log.info("word: " + word);
    }

    /**
     * ASCII for ‘0’ is 48
     * 48 x 1.1 is 52.8 which turns to 52 when cast to char
     * 52 represents ‘4’ in ASCII
     */
    private static void second() {
        char ch = '0';
        ch *= 1.1;
        log.info("" + ch);
    }

    public static void main(String[] args) {
        first();
        second();
    }
}
