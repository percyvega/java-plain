package com.percyvega.experiments.java8.interfaces.model;

public class Person implements DefaultMethodInterfacePerson {

    @Override
    public String getName() {
        return "Percy";
    }

    @Override
    public String toString() {
        return getName() + " is a " + getGender();
    }
}
