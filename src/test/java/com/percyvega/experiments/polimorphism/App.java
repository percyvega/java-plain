package com.percyvega.experiments.polimorphism;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class App {

    @Test
    public void testChild1() {
        new Child1();
    }

    @Test
    public void testChild2() throws FileNotFoundException {
        new Child2();
    }

    @Test
    public void testChild3() {
        new Child3();
    }

    @Test
    public void testChild4() {
        new Child4();
    }

}
