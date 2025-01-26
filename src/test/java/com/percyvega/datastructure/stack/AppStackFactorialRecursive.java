package com.percyvega.datastructure.stack;

import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 4/29/2017.
 */
@Log4j2
public class AppStackFactorialRecursive {

    private static int factorial(int n) {
        if (n == 1) {
            return n;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int result = factorial(10);

        log.info(result);
    }

}
