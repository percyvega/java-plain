package com.percyvega.experiments.ooo.constructors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Child1 extends Parent1 {

    public Child1() {
        // This can be commented out only because the call happens anyway
//        super();
        log.info("Line never reached");
    }

}

@Log4j2
class Parent1 {

    public Parent1() {
        throw new ParentNoArgsException("Parent's constructor() is being called.");
    }

}
