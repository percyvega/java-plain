package com.percyvega.experiments.testing.hamcrest;

import com.percyvega.experiments.testing.AwesomeCalculator;
import com.percyvega.experiments.testing.AwesomeCalculatorImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by percy on 1/16/2016.
 */
public class MatcherTest {

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
        assertThat(calculator.multiply(10, 5), is(50));
        assertThat(calculator1.getBigInteger(), equalTo((Object) BigInteger.ONE));
        assertThat(calculatorList, hasItem(calculator));
    }
    @Test
    public void then_assertFalse() {
        assertThat(calculator.add(10, 5), not(greaterThan(105)));
        assertThat(calculator, is(equalTo(calculator4)));
    }
    @Test
    public void then_assertNull() {
        assertThat(calculator.getBigInteger(), is(nullValue()));
        assertThat(calculator3, is(nullValue()));
    }
    @Test
    public void then_assertNotNull() {
        assertThat(calculator1.getBigInteger(), is(not(nullValue())));
        assertThat(calculator, not(nullValue()));
        assertThat(calculatorList.iterator(), notNullValue());
    }
    @Test
    public void then_assertEquals() {
        assertThat(calculator2, equalTo(calculator5));
        assertThat(calculator, equalTo(calculator));
    }
    @Test
    public void then_assertNotEquals() {
        assertThat(calculator1, is(not(equalTo(calculator2))));
        assertThat(calculator1.getBigInteger(), not(equalTo(calculator5.getBigInteger())));
    }
    @Test
    public void then_assertSame() {
        assertThat(calculator, sameInstance(calculator4));
        assertThat(calculator1.getBigInteger(), is(sameInstance((Object) BigInteger.ONE)));
    }
    @Test
    public void then_assertNotSame() {
        assertThat(calculator2, is(not(sameInstance(calculator5))));
        assertThat(new AwesomeCalculatorImpl(), not(sameInstance(new AwesomeCalculatorImpl())));
    }

}
