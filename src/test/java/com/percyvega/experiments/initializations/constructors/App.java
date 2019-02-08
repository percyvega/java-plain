package com.percyvega.experiments.initializations.constructors;

public class App {

    public static void main(String[] args) {
        Deer deer = new Reindeer(5);
        System.out.println(deer.toString());
        deer = new RedDeer(7);
        System.out.println(deer.toString());
    }

}
