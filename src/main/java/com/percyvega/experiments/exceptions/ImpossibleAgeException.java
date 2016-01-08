package com.percyvega.experiments.exceptions;

/**
 * Created by percy on 1/7/2016.
 */
public class ImpossibleAgeException extends Exception {
    public ImpossibleAgeException(int age) {
        super(age + " is not a valid age.");
    }
}
