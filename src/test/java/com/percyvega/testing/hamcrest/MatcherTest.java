package com.percyvega.testing.hamcrest;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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

    @BeforeAll
    public static void given() {
        calculator = new AwesomeCalculatorImpl();
        calculator1 = new AwesomeCalculatorImpl();
        calculator2 = new AwesomeCalculatorImpl();
        calculator3 = null;
        calculator4 = calculator;
        calculator5 = new AwesomeCalculatorImpl();
        calculatorList = new ArrayList();
    }

    @BeforeEach
    public void when() {
        calculator1.setBigInteger(BigInteger.ONE);
        calculator2.setBigInteger(BigInteger.TEN);
        calculator5.setBigInteger(BigInteger.TEN);
        calculatorList.addAll(Arrays.asList(calculator, calculator1, calculator2, calculator3, calculator4, calculator5));
    }

    @Test
    public void then_assertTrue() {
        assertThat(calculator.multiply(10, 5)).isEqualTo(50);
        assertThat(calculator1.getBigInteger()).isEqualTo(BigInteger.ONE);
        assertThat(calculatorList).contains(calculator);
    }

    @Test
    public void then_assertFalse() {
        assertThat(calculator.add(10, 5)).isLessThanOrEqualTo(105);
        assertThat(calculator).isEqualTo(calculator4);
    }

    @Test
    public void then_assertNull() {
        assertThat(calculator.getBigInteger()).isNull();
        assertThat(calculator3).isNull();
    }

    @Test
    public void then_assertNotNull() {
        assertThat(calculator).isNotNull();
        assertThat(calculatorList.iterator()).isNotNull();
    }

    @Test
    public void then_assertEquals() {
        assertThat(calculator2).isEqualTo(calculator5);
        assertThat(calculator).isEqualTo(calculator);
    }

    @Test
    public void then_assertNotEquals() {
        assertThat(calculator1).isNotEqualTo(calculator2);
        assertThat(calculator1.getBigInteger()).isNotEqualTo(calculator5.getBigInteger());
    }

    @Test
    public void then_assertSame() {
        assertThat(calculator).isSameAs(calculator4);
        assertThat(calculator1.getBigInteger()).isSameAs(BigInteger.ONE);
    }

    @Test
    public void then_assertNotSame() {
        assertThat(calculator2).isNotSameAs(calculator5);
        assertThat(new AwesomeCalculatorImpl()).isNotSameAs(new AwesomeCalculatorImpl());
    }

}
