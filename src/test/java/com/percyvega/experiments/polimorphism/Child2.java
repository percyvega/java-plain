package com.percyvega.experiments.polimorphism;

import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;

@Log4j2
public class Child2 extends Parent2 {

    public Child2() throws FileNotFoundException {
        publicMethod();
        publicMethodTestingRuntimeException();
        publicMethodTestingFileNotFoundException();
    }

    // won't compile because return type clashes with parent's
//    public void publicMethod() {
//        log.info(this.getClass().getSimpleName() + "'s publicMethod()");
//    }

    public void publicMethodTestingRuntimeException() {
        log.info(this.getClass().getSimpleName() + "'s publicMethodTestingRuntimeException()");
    }

    public void publicMethodTestingFileNotFoundException() {
        log.info(this.getClass().getSimpleName() + "'s publicMethodTestingFileNotFoundException()");
    }

}

@Log4j2
class Parent2 {

    public Parent2() throws FileNotFoundException {
        publicMethod();
        publicMethodTestingRuntimeException();
        publicMethodTestingFileNotFoundException();
    }

    public int publicMethod() {
        log.info(this.getClass().getSimpleName() + "'s publicMethod()");
        return 0;
    }

    public void publicMethodTestingRuntimeException() throws RuntimeException {
        log.info(this.getClass().getSimpleName() + "'s publicMethodTestingRuntimeException()");
    }

    public void publicMethodTestingFileNotFoundException() throws FileNotFoundException {
        log.info(this.getClass().getSimpleName() + "'s publicMethodTestingFileNotFoundException()");
    }

}
