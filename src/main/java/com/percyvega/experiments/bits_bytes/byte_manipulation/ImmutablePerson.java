package com.percyvega.experiments.bits_bytes.byte_manipulation;

import java.io.Serializable;

public final class ImmutablePerson implements Serializable {
    private final String firstName;
    private final String lastName;
    private final int age;

    public ImmutablePerson(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        if (!(0 <= this.age && this.age <= 300))
            throw new IllegalArgumentException("Age not greater than 0 or larger than 300");
        if (this.firstName == null || this.firstName.isEmpty())
            throw new IllegalArgumentException("firstName empty");
        if (this.lastName == null || this.lastName.isEmpty())
            throw new IllegalArgumentException("firstName empty");
    }

    public String toString() {
        return firstName + " " + lastName + " is " + age + " years old";
    }

}