package com.percyvega.experiments.version;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JavaVersion {

    public static void main(String[] args) {
        log.info("-------------------------------");
        String property = "java.version";
        printProperty(property);
        property = "java.runtime.version";
        printProperty(property);
        property = "java.specification.version";
        printProperty(property);
        log.info("ImplementationVersion: " + Runtime.class.getPackage().getImplementationVersion());
        log.info("-------------------------------");
    }

    private static void printProperty(String property) {
        log.info(property + ": " + System.getProperty(property));
    }
}
