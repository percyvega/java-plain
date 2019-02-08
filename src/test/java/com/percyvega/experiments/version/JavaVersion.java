package com.percyvega.experiments.version;

public class JavaVersion {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        String property = "java.version";
        printProperty(property);
        property = "java.runtime.version";
        printProperty(property);
        property = "java.specification.version";
        printProperty(property);
        System.out.println("ImplementationVersion: " + Runtime.class.getPackage().getImplementationVersion());
        System.out.println("-------------------------------");
    }

    private static void printProperty(String property) {
        System.out.println(property + ": " + System.getProperty(property));
    }
}
