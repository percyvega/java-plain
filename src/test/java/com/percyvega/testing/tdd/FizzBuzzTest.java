package com.percyvega.testing.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by percy on 1/16/2016.
 */
public class FizzBuzzTest {

    @Test
    public void numberDivisibleByThreeIsFizz() {
        assertThat(FizzBuzz.isFizz(3)).isEqualTo(true);
    }

    @Test
    public void numberNotDivisibleByThreeIsNotFizz() {
        assertThat(FizzBuzz.isFizz(2)).isEqualTo(false);
    }

    @Test
    public void numberDivisibleByFiveIsBuzz() {
        assertThat(FizzBuzz.isBuzz(10)).isEqualTo(true);
    }

    @Test
    public void numberNotDivisibleByFiveIsNotBuzz() {
        assertThat(FizzBuzz.isBuzz(9)).isEqualTo(false);
    }

    @Test
    public void numberDivisibleByThreeAndFiveIsFizzBuzz() {
        assertThat(FizzBuzz.isFizzBuzz(15)).isEqualTo(true);
    }

    @Test
    public void numberNotDivisibleByThreeAndFiveIsNotFizzBuzz() {
        assertThat(FizzBuzz.isFizzBuzz(14)).isEqualTo(false);
    }

    @Test
    public void verifyEvaluationsOfFizzNumber() {
        assertThat(FizzBuzz.evaluate(66)).isEqualTo("Fizz");
    }

    @Test
    public void verifyEvaluationsOfBuzzNumber() {
        assertThat(FizzBuzz.evaluate(10)).isEqualTo("Buzz");
    }

    @Test
    public void verifyEvaluationsOfFizzBuzzNumber() {
        assertThat(FizzBuzz.evaluate(30)).isEqualTo("Fizz Buzz");
    }

}