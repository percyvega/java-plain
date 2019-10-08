package com.percyvega.experiments.polimorphism;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Child1 extends Parent1 {

    public Child1() {
        privateMethod();
        finalMethod();
        staticMethod();
    }

    private void privateMethod() {
        log.info(this.getClass().getSimpleName() + "'s privateMethod()");
    }

    // won't compile
//    public final void finalMethod() {
//        log.info(this.getClass().getSimpleName() + "'s finalMethod()");
//    }

    public static void staticMethod() {
        log.info(Child1.class.getSimpleName() + "'s staticMethod()");
    }

}

@Log4j2
class Parent1 {

    public Parent1() {
        privateMethod();
        finalMethod();
        staticMethod();
    }

    public void callMethods() {
        privateMethod();
        finalMethod();
        staticMethod();
    }

    private void privateMethod() {
        log.info(this.getClass().getSimpleName() + "'s privateMethod()");
    }

    public final void finalMethod() {
        log.info(this.getClass().getSimpleName() + "'s finalMethod()");
    }

    public static void staticMethod() {
        log.info(Parent1.class.getSimpleName() + "'s staticMethod()");
    }

}
