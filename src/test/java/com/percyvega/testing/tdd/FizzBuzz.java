package com.percyvega.testing.tdd;

/**
 * Created by percy on 1/16/2016.
 */
public class FizzBuzz {

    public static boolean isFizz(int number) {
        return number % 3 == 0;
    }

    public static boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    public static boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }

    public static void printFizzBuzzFor(int countNumbers) {
        for (int i = 1; i <= countNumbers; i++) {
            System.out.print(evaluate(i));

            if(i != countNumbers)
                System.out.print(", ");
        }

    }

    public static void main(String[] args) {
        printFizzBuzzFor(36);
    }

    public static String evaluate(int number) {
        String result = Integer.toString(number);

        if (isFizzBuzz(number))
            result = "Fizz Buzz";
        else if (isFizz(number))
            result = "Fizz";
        else if (isBuzz(number))
            result = "Buzz";

        return result;
    }
}
