package com.percyvega.experiments.testing.doubles;

import com.percyvega.experiments.testing.AwesomeCalculator;
import com.percyvega.experiments.testing.AwesomeCalculatorImpl;
import com.percyvega.experiments.testing.RandomIntsRepo;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by percy on 1/17/2016.
 */
public class AwesomeCalculatorMockitoStubTest {

    private static final int[] randomIntsFixtures = new int[] {3, 3, 3, 5, 5, 5};

    @Test
    public void shouldPredictAverageOfRandomInts() throws Exception {

        // given
        RandomIntsRepo stub = Mockito.mock(RandomIntsRepo.class);
        Mockito.when(stub.getRandomInts()).thenReturn(randomIntsFixtures);
        AwesomeCalculator calculator = new AwesomeCalculatorImpl(stub);

        // when
        int average = calculator.getAverageRandomInts();

        // then
        assertThat(average, is(4));
        System.out.println(average);

    }

}