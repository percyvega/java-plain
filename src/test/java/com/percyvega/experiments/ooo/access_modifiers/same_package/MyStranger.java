package com.percyvega.experiments.ooo.access_modifiers.same_package;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyStranger {

    private final MyFather notMyFather;

    public MyStranger(String ssn, String phone, String lastName, String firstName) {
        notMyFather = new MyFather(ssn, phone, lastName, firstName);
    }

    public void printFatherValues() {
        log.info(notMyFather.getSsn());
        log.info(notMyFather.getPhone());
        log.info(notMyFather.getLastName());
        log.info(notMyFather.getFirstName());
    }

    public void printFatherValuesWithoutGetters() {
//        log.info(notMyFather.ssn); // inaccessible, because it's private
        log.info(notMyFather.phone);
        log.info(notMyFather.lastName);
        log.info(notMyFather.firstName);
    }
}
