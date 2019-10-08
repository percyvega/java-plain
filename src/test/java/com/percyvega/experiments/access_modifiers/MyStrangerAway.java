package com.percyvega.experiments.access_modifiers;

import com.percyvega.experiments.access_modifiers.same_package.MyFather;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyStrangerAway {

    private MyFather notMyFather;

    public MyStrangerAway(String ssn, String phone, String lastName, String firstName) {
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
//        log.info(notMyFather.phone); // inaccessible, because it's package
//        log.info(notMyFather.lastName); // inaccessible, because it's protected
        log.info(notMyFather.firstName);
    }
}
