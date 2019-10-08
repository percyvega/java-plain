package com.percyvega.testing.junit;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@Log4j2
public class ExceptionsTest {

    private AwesomeCalculator tester = new AwesomeCalculatorImpl();

    @Test
    public void testMultipleAsserts() {
        log.debug("Starting @Test testMultipleAsserts()");

        assertTrue("AwesomeCalculatorImpl".equals(tester.getClass().getSimpleName()));

        assertFalse("Refrigerator".equals(tester.getClass().getSimpleName()));

        assertSame(tester.getClass(), tester.getClass());

        assertSame(tester.getClass().getSimpleName(), tester.getClass().getSimpleName());

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

            log.debug("Should not reach this LOC!!!");
            fail("expected NPE before this LOC");
        } catch (NullPointerException e) {
            log.debug("Caught successfully testHandleNullPointerException()");
        } finally {
            log.debug("Finished testHandleNullPointerException()");
        }
    }

}
