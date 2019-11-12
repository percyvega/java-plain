package com.percyvega.experiments.ooo.polimorphism;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class Child3 extends Parent3 {

    // compilation error: this overriden method has a different return value
//    public long getSum(int x, int y) {
//        return x + y;
//    }

    // notice it is legal that we are assigning a stronger access privilege; was packageLocal an now it's public
    //
    @Override
    public ArrayList<String> getNewList() {
        return new ArrayList<>(Arrays.asList("Three", "Four"));
    }

    // compilation error; incompatible return type, it can extend the original but not be a super type
//    @Override
//    public List<String> getNewArrayList() {
//        return Arrays.asList("Seven", "Eight");
//    }

}

@Log4j2
class Parent3 {

    public int getSum(int x, int y) {
        return x + y;
    }

    List<String> getNewList() {
        return Arrays.asList("One", "Two");
    }

    protected ArrayList<String> getNewArrayList() {
        return new ArrayList<>(Arrays.asList("Five", "Six"));
    }

}
