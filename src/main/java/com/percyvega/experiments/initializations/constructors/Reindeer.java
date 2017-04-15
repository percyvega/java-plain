package com.percyvega.experiments.initializations.constructors;

public class Reindeer extends Deer {

    public Reindeer(int age) {
//        super();
        setAge(age);
        System.out.println("Calling public Reindeer(int age)");
    }

    public boolean hasHorns() {
        System.out.println("Calling Reindeer's public boolean hasHorns()");
        return true;
    }
}
