package com.percyvega.datastructure.stack;

/**
 * Created by percy on 4/29/2017.
 */
public class AppStackFactorialRecursive {

    private static int factorial(int n) {
        if(n == 1) {
            return n;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int result = factorial(10);

        System.out.println(result);
    }

}
