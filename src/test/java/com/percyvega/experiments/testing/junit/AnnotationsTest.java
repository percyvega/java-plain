package com.percyvega.experiments.testing.junit;

import com.percyvega.experiments.testing.AwesomeCalculator;
import com.percyvega.experiments.testing.AwesomeCalculatorImpl;
import org.apache.log4j.Logger;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AnnotationsTest {

    static final Logger logger = Logger.getLogger(AnnotationsTest.class);

    private static AwesomeCalculator tester;

    @BeforeClass
    public static void beforeClass() {
        logger.debug("Starting @BeforeClass");

        tester = new AwesomeCalculatorImpl();
    }

    @AfterClass
    public static void afterClass() {
        logger.debug("Starting @AfterClass\n");
    }

    @Before
    public void before() {
        logger.debug("Starting @Before");
    }

    @After
    public void after() {
        logger.debug("Starting @After");
    }

    @Ignore
    @Test(timeout = 40000)
    public void ignoredInfiniteLoop() {
        logger.debug("Starting @Ignore @Test(timeout = 4000) ignoredInfiniteLoop()");

        while (true)
            ;
    }

    @Test
    public void multiply() {
        logger.debug("Starting @Test testMultiply()");
        assertEquals("10 x 5 must be 50", (long) 50, (long) tester.multiply(10, 5));
    }

    @Test
    public void divide() {
        logger.debug("Starting @Test testDivide()");
        assertEquals("10 / 5 must be 2", (long) 2, (long) tester.divide(10, 5));
    }

    @Test
    public void add() {
        logger.debug("Starting @Test testAdd()");
        assertEquals("10 + 5 must be 15", (long) 15, (long) tester.add(10, 5));
    }

    @Test
    public void subtract() {
        logger.debug("Starting @Test testSubtract()");
        assertEquals("10 - 5 must be 5", (long) 5, (long) tester.subtract(10, 5));
    }

}
