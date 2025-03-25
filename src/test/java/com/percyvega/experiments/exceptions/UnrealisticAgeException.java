package com.percyvega.experiments.exceptions;

public class UnrealisticAgeException extends Exception {
    public UnrealisticAgeException(int age) {
        super(age + " is not a realistic age.");
    }
}
