package com.percyvega.testing.doubles;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import com.percyvega.testing.RandomIntsRepo;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by percy on 1/17/2016.
 */
public class AwesomeCalculatorStubTest {

    private static final int[] randomIntsFixtures = new int[] {3, 3, 3, 5, 5, 5};

    @Test
    public void shouldPredictAverageOfRandomInts() throws Exception {

        // given
        RandomIntsRepo stub = new RandomIntsRepo();
        stub.setRandomInts(randomIntsFixtures);
        AwesomeCalculator calculator = new AwesomeCalculatorImpl(stub);

        // when
        int average = calculator.getAverageRandomInts();

        // then
        assertThat(average, is(4));
        System.out.println(average);

    }

}