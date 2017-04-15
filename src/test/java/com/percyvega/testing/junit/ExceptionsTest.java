package com.percyvega.testing.junit;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class ExceptionsTest {

    static final Logger logger = Logger.getLogger(ExceptionsTest.class);

    private AwesomeCalculator tester = new AwesomeCalculatorImpl();

    @Test
    public void testMultipleAsserts() {
        logger.debug("Starting @Test testMultipleAsserts()");

        assertTrue("AwesomeCalculatorImpl".equals(tester.getClass().getSimpleName()));

        assertFalse("Refrigerator".equals(tester.getClass().getSimpleName()));

        assertSame(tester.getClass(), tester.getClass());

        assertNotSame(tester.getClass().getSimpleName(), tester.getClass().getSimpleName());

        assertEquals(tester.getClass().getSimpleName(), tester.getClass().getSimpleName());

        assertNotEquals("Refrigerator", tester.getClass().getSimpleName());

        assertThat("this string", is(not("that string")));
    }

    @Test(expected = NullPointerException.class)
    public void testThrowNullPointerException() {
        new AwesomeCalculatorImpl().getBigInteger().bitCount();
    }

    @Test
    public void testHandleNullPointerException() {
        try {
            testThrowNullPointerException();

            logger.debug("Should not reach this LOC!!!");
            fail("expected NPE before this LOC");
        } catch (NullPointerException e) {
            logger.debug("Caught successfully testHandleNullPointerException()");
        } finally {
            logger.debug("Finished testHandleNullPointerException()");
        }
    }

}
