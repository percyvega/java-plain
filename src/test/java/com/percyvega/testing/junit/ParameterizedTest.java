package com.percyvega.testing.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

    private int number;

    public ParameterizedTest(int number) {
        this.number = number;
    }

    @Parameters
    public static Collection<Object[]> data() {
        // Must return an Iterable of arrays
        Object[][] data = new Object[][]{{1}, {2}, {3}, {4}};
        return Arrays.asList(data);
    }

    @Test
    public void incrementTest() {
        System.out.println("Parameterized Number is : " + number + ". Increment Result: " + ++number);
    }

    @Test
    public void decrementTest() {
        System.out.println("Parameterized Number is : " + number + ". Decrement Result: " + --number);
    }
}