package com.percyvega.experiments.ooo.access_modifiers.same_package;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyGrandchild extends MyChild {

    private String firstName = "Nicholas";

    public MyGrandchild(String ssn, String phone, String lastName, String firstName) {
        super(ssn, phone, lastName, firstName);
    }

    @Override
    public String getSsn() {
        return "Grandfather SSN is " + super.getSsn();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
}
