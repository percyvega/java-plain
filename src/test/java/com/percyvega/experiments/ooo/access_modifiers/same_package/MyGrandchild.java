package com.percyvega.experiments.ooo.access_modifiers.same_package;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyGrandchild extends MyChild {

    public String firstName = "Francesca";

    public MyGrandchild(String ssn, String phone, String lastName, String firstName) {
        super(ssn, phone, lastName, firstName);
    }

    public String getSsn() {
        return "Grandfather SSN is " + super.getSsn();
    }

    public String getFirstName() {
        return firstName;
    }
}
