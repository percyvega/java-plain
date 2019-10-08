package com.percyvega.experiments.constructors;

import org.junit.Test;

public class App {

    @Test(expected = ParentNoArgsException.class)
    public void testChild1() {
        new Child1();
    }

    @Test(expected = ParentOneArgException.class)
    public void testChild2() {
        new Child2();
    }

    @Test(expected = ParentNoArgsException.class)
    public void testChild3() {
        new Child3("Percy");
    }

    @Test(expected = ParentOneArgException.class)
    public void testChild4() {
        new Child4("Percy");
    }

}
