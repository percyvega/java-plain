package com.percyvega.testing.junit;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by percy on 1/15/2016.
 */
public class AssertionTests {

    private static AwesomeCalculator calculator;
    private static AwesomeCalculator calculator1;
    private static AwesomeCalculator calculator2;
    private static AwesomeCalculator calculator3;
    private static AwesomeCalculator calculator4;
    private static AwesomeCalculator calculator5;

    private static List<AwesomeCalculator> calculatorList;

    @BeforeClass
    public static void given() {
        calculator = new AwesomeCalculatorImpl();
        calculator1 = new AwesomeCalculatorImpl();
        calculator2 = new AwesomeCalculatorImpl();
        calculator3 = null;
        calculator4 = calculator;
        calculator5 = new AwesomeCalculatorImpl();
        calculatorList = new ArrayList<AwesomeCalculator>();
    }

    @Before
    public void when() {
        calculator1.setBigInteger(BigInteger.ONE);
        calculator2.setBigInteger(BigInteger.TEN);
        calculator5.setBigInteger(BigInteger.TEN);
        calculatorList.addAll(Arrays.asList(calculator, calculator1, calculator2, calculator3, calculator4, calculator5));
    }

    @Test
    public void then_assertTrue() {
        assertTrue(calculator.multiply(10, 5) == 50);
        assertTrue(calculator1.getBigInteger().equals(BigInteger.ONE));
        assertTrue(calculatorList.contains(calculator));
    }
    @Test
    public void then_assertFalse() {
        assertFalse("Wrong addition result", calculator.add(10, 5) != 15);
        assertFalse(calculator != calculator4);
        assertFalse(calculatorList.isEmpty());
    }
    @Test
    public void then_assertNull() {
        assertNull(calculator.getBigInteger());
        assertNull(calculator3);
    }
    @Test
    public void then_assertNotNull() {
        assertNotNull(calculator1.getBigInteger());
        assertNotNull(calculator);
        assertNotNull(calculatorList.iterator());
    }
    @Test
    public void then_assertEquals() {
        assertEquals(calculator2, calculator5);
        assertEquals(calculator, calculator);
    }
    @Test
    public void then_assertNotEquals() {
        assertNotEquals(calculator1, calculator2);
        assertNotEquals(calculator1.getBigInteger(), calculator5.getBigInteger());
    }
    @Test
    public void then_assertSame() {
        assertSame(calculator, calculator4);
        assertSame(BigInteger.ONE, calculator1.getBigInteger());
    }
    @Test
    public void then_assertNotSame() {
        assertNotSame(calculator2, calculator5);
        assertNotSame(new AwesomeCalculatorImpl(), new AwesomeCalculatorImpl());
    }

}
