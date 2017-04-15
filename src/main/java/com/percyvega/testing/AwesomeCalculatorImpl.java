package com.percyvega.testing;

import java.math.BigInteger;

public class AwesomeCalculatorImpl implements AwesomeCalculator {

    private BigInteger bigInteger;
    private RandomIntsRepo repo;

    public AwesomeCalculatorImpl() {
    }

    public AwesomeCalculatorImpl(RandomIntsRepo repo) {
        this.repo = repo;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public int multiply(int i, int y) {
        return i * y;
    }

    public int divide(int i, int y) {
        return i / y;
    }

    public int add(int i, int y) {
        return i + y;
    }

    public int subtract(int i, int y) {
        return i - y;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public int getAverageRandomInts() {
        int sum = 0;
        int[] myInts = repo.getRandomInts();

        for (int i = 0; i < myInts.length; i++) {
            sum += myInts[i];
        }

        return sum / myInts.length;
    }

    @Override
    public boolean equals(Object obj) {
        return this.bigInteger == ((AwesomeCalculatorImpl) obj).getBigInteger();
    }
}
