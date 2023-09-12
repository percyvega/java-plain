package com.percyvega.experiments.java8.interfaces.model;

// The @FunctionalInterface annotation only helps to check (at compile time) if this interface contains a
//      Single Abstract Method (SAM) or not.
@FunctionalInterface
public interface SamInterface {
    String doSomething(String s);
}