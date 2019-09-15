package com.percyvega.experiments.initializations.constructors2;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class App {

    @Test(expected = FatherNoArgsException.class)
    public void testChild1() {
        new Child1();
    }

    @Test(expected = FatherOneArgException.class)
    public void testChild2() {
        new Child2();
    }

    @Test(expected = FatherNoArgsException.class)
    public void testChild3() {
        new Child3("Percy");
    }

    @Test(expected = FatherOneArgException.class)
    public void testChild4() {
        new Child4("Percy");
    }

}
