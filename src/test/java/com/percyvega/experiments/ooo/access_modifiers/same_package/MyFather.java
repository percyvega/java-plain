package com.percyvega.experiments.ooo.access_modifiers.same_package;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyFather {

    public String firstName;
    protected String lastName;
    String phone;
    private String ssn;

    public MyFather(String ssn, String phone, String lastName, String firstName) {
        this.ssn = ssn;
        this.phone = phone;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public void printFatherValues() {
        log.info(getSsn());
        log.info(getPhone());
        log.info(getLastName());
        log.info(getFirstName());
    }

    public void printFatherValuesWithoutGetters() {
        log.info(ssn);
        log.info(phone);
        log.info(lastName);
        log.info(firstName);
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
