package com.percyvega.experiments.serialization.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.time.Month;

@Data // will add getters, setters, equals(Object o) and hashCode()
public class Person implements Serializable {

    // it is strongly recommended that all serializable classes explicitly declare serialVersionUID values, since the
    //      default serialVersionUID computation is highly sensitive to class details that may vary depending on compiler
    //      implementations, and can thus result in unexpected InvalidClassExceptions during deserialization.
    @Serial
    private static final long serialVersionUID = 23458972348L;

    private String firstName;
    private String lastName;
    private String password;
    @EqualsAndHashCode.Include
    private transient String fullName;
    private MySingleton mySingleton = MySingleton.getInstance();
    private Month favoriteMonth = Month.JANUARY;

    public Person(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.fullName = this.firstName + " " + this.lastName;
    }

}
