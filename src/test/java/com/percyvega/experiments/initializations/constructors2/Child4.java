package com.percyvega.experiments.initializations.constructors2;

public class Child4 extends Father4 {

    public Child4(String name) {
        super(name);
        throw new ChildNoArgsException("Child's constructor() is being called.");
    }

}

class Father4 {

    // This can be commented our only because Child4's constructor specified another constructor
//    public Father4() {
//        throw new FatherNoArgsException("Father's constructor() is being called.");
//    }

    public Father4(String name) {
        throw new FatherOneArgException("Father's constructor(String) is being called.");
    }

}
