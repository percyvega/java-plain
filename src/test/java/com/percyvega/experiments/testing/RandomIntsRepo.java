package com.percyvega.experiments.testing;

import java.util.Random;

public class RandomIntsRepo {

    private int[] randomInts = new int[10000];

    public RandomIntsRepo() {
        Random random = new Random();
        for (int i = 0; i < randomInts.length; i++) {
            int randomInt = random.nextInt(10000);
            randomInts[i] = randomInt;
        }
    }

    public int[] getRandomInts() {
        return randomInts;
    }

    public void setRandomInts(int[] randomInts) {
        this.randomInts = randomInts;
    }

}
