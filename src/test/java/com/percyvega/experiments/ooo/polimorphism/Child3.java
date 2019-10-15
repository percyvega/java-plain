package com.percyvega.experiments.ooo.polimorphism;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Child3 extends Parent3 {

    // compilation error: this overriden method has a different return value
//    public long getSum(int x, int y) {
//        return x + y;
//    }

}

@Log4j2
class Parent3 {

    public int getSum(int x, int y) {
        return x + y;
    }

}
