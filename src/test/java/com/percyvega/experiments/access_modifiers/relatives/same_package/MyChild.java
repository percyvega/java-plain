package com.percyvega.experiments.access_modifiers.relatives.same_package;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyChild extends MyFather {
    public MyChild(String ssn, String phone, String lastName, String firstName) {
        super(ssn, phone, lastName, firstName);
    }

    public void printInheritedValues() {
        log.info(getSsn()); // accessible, because it inherited getSsn()
        log.info(getPhone());
        log.info(getLastName());
        log.info(getFirstName());
    }

    public void printInheritedValuesWithoutGetters() {
//        log.info(ssn); // inaccessible, because it didn't inherit it
        log.info(phone);
        log.info(lastName);
        log.info(firstName);
    }

    public void printSuperValues() {
        log.info(super.getSsn());
        log.info(super.getPhone());
        log.info(super.getLastName());
        log.info(super.getFirstName());
    }

    public void printSuperValuesWithoutGetters() {
//        log.info(super.ssn); // inaccessible because it's private
        log.info(super.phone);
        log.info(super.lastName);
        log.info(super.firstName);
    }

}