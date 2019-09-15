package com.percyvega.experiments.initializations.constructors2;

public class Child1 extends Father1 {

    public Child1() {
        // This can be commented our only because the call is implicit
//        super();
        throw new ChildNoArgsException("Child's constructor() is being called.");
    }

}

class Father1 {

    public Father1() {
        throw new FatherNoArgsException("Father's constructor() is being called.");
    }

}
