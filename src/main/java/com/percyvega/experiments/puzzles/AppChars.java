package com.percyvega.experiments.puzzles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class AppChars {

    private static final Logger logger = LoggerFactory.getLogger(AppChars.class);

    private static Random rnd = new Random();

    public static void main(String[] args) {
        int cap = 'P';
        logger.debug(String.valueOf(cap));

        StringBuffer word = new StringBuffer('P');
        int randomInt = rnd.nextInt(2);
        logger.debug(String.valueOf(randomInt));

        logger.debug("word: " + word);
        switch (randomInt) {
            case 1:
                word = new StringBuffer('P');
                logger.debug("inside " + randomInt);
                logger.debug("word: " + word);
                break;
            case 2:
                word = new StringBuffer('G');
                logger.debug("inside " + randomInt);
                logger.debug("word: " + word);
                break;
            default:
                word = new StringBuffer('M');
                logger.debug("inside " + randomInt);
                logger.debug("word: " + word);
                break;
        }
        logger.debug("word: " + word);

        word.append('a');
        word.append('i');
        word.append('n');
        logger.debug("word: " + word);
    }
}