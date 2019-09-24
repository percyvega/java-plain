package com.percyvega.experiments.initializations.constructors;

public class Child1 extends Father1 {

    public Child1() {
        // This can be commented out only because the call happens anyway
//        super();
        System.out.println("Line never reached");
    }

}

class Father1 {

    public Father1() {
        throw new FatherNoArgsException("Father's constructor() is being called.");
    }

}
