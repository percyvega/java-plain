package com.percyvega.experiments.java8.interfacemultipleinheritance.model;

@FunctionalInterface
public interface Employee {

    String getName();

    default String getRole() {
        return "Manager";
    }

    static String getSalute(String addressee) {
        return "Good morning, " + addressee;
    }

}
