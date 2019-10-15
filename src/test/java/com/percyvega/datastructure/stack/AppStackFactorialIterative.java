package com.percyvega.datastructure.stack;

/**
 * Created by percy on 4/29/2017.
 */
public class AppStackFactorialIterative {

    private static Stack<Integer> stack = new Stack<>();

    private static int factorial(int n) {
        if (n < 1) {
            throw new RuntimeException("Factorial of " + n + " is undefined");
        }

        // populate stack
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        int result = 1;

        // read from stack
        while (!stack.isEmpty())
            result *= stack.pop();

        return result;
    }

    public static void main(String[] args) {
        int result = factorial(10);

        System.out.println(result);
    }

}
