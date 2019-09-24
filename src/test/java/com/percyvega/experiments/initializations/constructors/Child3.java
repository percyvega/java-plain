package com.percyvega.experiments.initializations.constructors;

public class Child3 extends Father3 {

    public Child3(String name) {
        // This can be commented out only because the call is implicit
//        super();
        throw new ChildOneArgException("Child's constructor(String) is being called.");
    }

}

class Father3 {

    public Father3() {
        throw new FatherNoArgsException("Father's constructor() is being called.");
    }

}
