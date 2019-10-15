package com.percyvega.experiments.ooo.constructors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Child4 extends Parent4 {

    public Child4(String name) {
        super(name);
        throw new ChildNoArgsException("Child's constructor() is being called.");
    }

}

@Log4j2
class Parent4 {

    // This can be commented out only because Child4's constructor specified another constructor
//    public Parent4() {
//        throw new ParentNoArgsException("Parent's constructor() is being called.");
//    }

    public Parent4(String name) {
        throw new ParentOneArgException("Parent's constructor(String) is being called.");
    }

}
