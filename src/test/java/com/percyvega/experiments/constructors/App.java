package com.percyvega.experiments.constructors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class App {

    @Test
    public void testChild1() {
        Assertions.assertThrows(ParentNoArgsException.class, () -> new Child1());
    }

    @Test
    public void testChild2() {
        Assertions.assertThrows(ParentOneArgException.class, () -> new Child2());
    }

    @Test
    public void testChild3() {
        Assertions.assertThrows(ParentNoArgsException.class, () -> new Child3("Percy"));
    }

    @Test
    public void testChild4() {
        Assertions.assertThrows(ParentOneArgException.class, () -> new Child4("Percy"));
    }

}
