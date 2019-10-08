package com.percyvega.experiments.constructors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Child2 extends Parent2 {

    public Child2() {
        // if I comment out the next line, the compiler will try to call the parent's default constructor, so this won't compile
        super("New name!");
        log.info("Line never reached");
    }

}

@Log4j2
class Parent2 {

    // This can be commented out only because it's never called, hence unused
//    public Parent2() {
//        throw new ParentNoArgsException("Parent's constructor() is being called.");
//    }

    public Parent2(String name) {
        throw new ParentOneArgException("Parent's constructor(String) is being called.");
    }

}
