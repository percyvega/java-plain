package com.percyvega.testing.tdd;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by percy on 1/16/2016.
 */
public class FizzBuzzTest {

    @Test
    public void numberDivisibleByThreeIsFizz() {
        assertThat(FizzBuzz.isFizz(3), is(true));
    }

    @Test
    public void numberNotDivisibleByThreeIsNotFizz() {
        assertThat(FizzBuzz.isFizz(2), is(false));
    }

    @Test
    public void numberDivisibleByFiveIsBuzz() {
        assertThat(FizzBuzz.isBuzz(10), is(true));
    }

    @Test
    public void numberNotDivisibleByFiveIsNotBuzz() {
        assertThat(FizzBuzz.isBuzz(9), is(false));
    }

    @Test
    public void numberDivisibleByThreeAndFiveIsFizzBuzz() {
        assertThat(FizzBuzz.isFizzBuzz(15), is(true));
    }

    @Test
    public void numberNotDivisibleByThreeAndFiveIsNotFizzBuzz() {
        assertThat(FizzBuzz.isFizzBuzz(14), is(false));
    }

    @Test
    public void verifyEvaluationsOfFizzNumber() {
        assertThat(FizzBuzz.evaluate(66), is(equalTo("Fizz")));
    }

    @Test
    public void verifyEvaluationsOfBuzzNumber() {
        assertThat(FizzBuzz.evaluate(10), is("Buzz"));
    }

    @Test
    public void verifyEvaluationsOfFizzBuzzNumber() {
        assertThat(FizzBuzz.evaluate(30), is("Fizz Buzz"));
    }

}