package com.percyvega.testing.junit;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
public class AnnotationsTest {

    private static AwesomeCalculator tester;

    @BeforeAll
    public static void beforeClass() {
        log.info("Starting @BeforeAll");

        tester = new AwesomeCalculatorImpl();
    }

    @AfterAll
    public static void afterClass() {
        log.info("Starting @AfterAll\n");
    }

    @BeforeEach
    public void before() {
        log.info("Starting @BeforeEach");
    }

    @AfterEach
    public void after() {
        log.info("Starting @After");
    }

    @Test
    public void ignoredInfiniteLoop() {
        log.info("Starting @Ignore @Test(timeout = 4000) ignoredInfiniteLoop()");

//        while (true)
//            ;
    }

    @Test
    public void multiply() {
        log.info("Starting @Test testMultiply()");
        assertEquals(50, tester.multiply(10, 5), "10 x 5 must be 50");
    }

    @Test
    public void divide() {
        log.info("Starting @Test testDivide()");
        assertEquals(2, tester.divide(10, 5), "10 / 5 must be 2");
    }

    @Test
    public void add() {
        log.info("Starting @Test testAdd()");
        assertEquals(15, tester.add(10, 5), "10 + 5 must be 15");
    }

    @Test
    public void subtract() {
        log.info("Starting @Test testSubtract()");
        assertEquals(5, tester.subtract(10, 5), "10 - 5 must be 5");
    }

}
