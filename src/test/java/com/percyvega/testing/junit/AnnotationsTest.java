package com.percyvega.testing.junit;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.*;

import static org.junit.Assert.assertEquals;

@Log4j2
public class AnnotationsTest {

    private static AwesomeCalculator tester;

    @BeforeClass
    public static void beforeClass() {
        log.debug("Starting @BeforeClass");

        tester = new AwesomeCalculatorImpl();
    }

    @AfterClass
    public static void afterClass() {
        log.debug("Starting @AfterClass\n");
    }

    @Before
    public void before() {
        log.debug("Starting @Before");
    }

    @After
    public void after() {
        log.debug("Starting @After");
    }

    @Test(timeout = 1000)
    public void ignoredInfiniteLoop() {
        log.debug("Starting @Ignore @Test(timeout = 4000) ignoredInfiniteLoop()");

//        while (true)
//            ;
    }

    @Test
    public void multiply() {
        log.debug("Starting @Test testMultiply()");
        assertEquals("10 x 5 must be 50", (long) 50, (long) tester.multiply(10, 5));
    }

    @Test
    public void divide() {
        log.debug("Starting @Test testDivide()");
        assertEquals("10 / 5 must be 2", (long) 2, (long) tester.divide(10, 5));
    }

    @Test
    public void add() {
        log.debug("Starting @Test testAdd()");
        assertEquals("10 + 5 must be 15", (long) 15, (long) tester.add(10, 5));
    }

    @Test
    public void subtract() {
        log.debug("Starting @Test testSubtract()");
        assertEquals("10 - 5 must be 5", (long) 5, (long) tester.subtract(10, 5));
    }

}
