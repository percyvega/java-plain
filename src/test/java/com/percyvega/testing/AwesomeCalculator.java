package com.percyvega.testing;

import java.math.BigInteger;

/**
 * Created by percy on 1/16/2016.
 */
public interface AwesomeCalculator {

    int multiply(int i, int y);

    int divide(int i, int y);

    int add(int i, int y);

    int subtract(int i, int y);

    Object getBigInteger();

    void setBigInteger(BigInteger one);

    int getAverageRandomInts();

}
