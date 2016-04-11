package com.percyvega.experiments.initializations.constructors;

public class RedDeer extends Deer {

    public RedDeer(int age) {
        super(age);
        System.out.println("Calling public Reindeer(int age)");
    }

    public boolean hasHorns() {
        System.out.println("Calling Reindeer's public boolean hasHorns()");
        return true;
    }
}
