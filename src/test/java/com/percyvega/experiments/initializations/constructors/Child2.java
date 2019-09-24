package com.percyvega.experiments.initializations.constructors;

public class Child2 extends Father2 {

    public Child2() {
        // if I comment out the next line, the compiler will try to call the parent's default constructor, so this won't compile
        super("New name!");
        System.out.println("Line never reached");
    }

}

class Father2 {

    // This can be commented out only because it's never called, hence unused
//    public Father2() {
//        throw new FatherNoArgsException("Father's constructor() is being called.");
//    }

    public Father2(String name) {
        throw new FatherOneArgException("Father's constructor(String) is being called.");
    }

}
