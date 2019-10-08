package com.percyvega.experiments.constructors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Child3 extends Parent3 {

    public Child3(String name) {
        // This can be commented out only because the call is implicit
//        super();
        throw new ChildOneArgException("Child's constructor(String) is being called.");
    }

}

@Log4j2
class Parent3 {

    public Parent3() {
        throw new ParentNoArgsException("Parent's constructor() is being called.");
    }

}
