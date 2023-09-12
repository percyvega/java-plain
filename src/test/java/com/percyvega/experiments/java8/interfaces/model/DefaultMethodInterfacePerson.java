package com.percyvega.experiments.java8.interfaces.model;

import static com.percyvega.experiments.java8.model.Constants.MALE;

public interface DefaultMethodInterfacePerson {

    default String getName() {
        return "Joe";
    }

    default String getGender() {
        return MALE;
    }

    static int countNameCharacters(Person person) {
        return person.getName().length();
    }

}
