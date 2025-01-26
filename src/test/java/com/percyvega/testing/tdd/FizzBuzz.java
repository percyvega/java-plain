package com.percyvega.testing.tdd;

import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 1/16/2016.
 */
@Log4j2
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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= countNumbers; i++) {
            stringBuilder.append(evaluate(i));

            if (i != countNumbers)
                stringBuilder.append(", ");
        }
        log.info(stringBuilder);
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
