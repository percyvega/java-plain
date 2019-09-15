package com.percyvega.experiments.initializations.constructors2;

public class Child2 extends Father2 {

    public Child2() {
        super("New name!");
        throw new ChildNoArgsException("Child's constructor() is being called.");
    }

}

class Father2 {

    // This can be commented our only because Child2's constructor specified another constructor
//    public Father2() {
//        throw new FatherNoArgsException("Father's constructor() is being called.");
//    }

    public Father2(String name) {
        throw new FatherOneArgException("Father's constructor(String) is being called.");
    }

}
