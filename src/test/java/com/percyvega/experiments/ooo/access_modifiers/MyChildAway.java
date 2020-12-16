package com.percyvega.experiments.ooo.access_modifiers;

import com.percyvega.experiments.ooo.access_modifiers.same_package.MyFather;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyChildAway extends MyFather {
    public MyChildAway(String ssn, String phone, String lastName, String firstName) {
        super(ssn, phone, lastName, firstName);
    }

    public void printInheritedValues() {
        log.info(getSsn()); // accessible, because it inherited getSsn()
        log.info(getPhone());
        log.info(getLastName());
        log.info(getFirstName());
    }

    public void printInheritedValuesWithoutGetters() {
//        log.info(ssn); // inaccessible, because it can't reach visibly the field
//        log.info(phone); // inaccessible, because it can't reach visibly the field
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
//        log.info(super.ssn); // inaccessible, because it's private
//        log.info(super.phone); // inaccessible, because it's package
        log.info(super.lastName);
        log.info(super.firstName);
    }

}
