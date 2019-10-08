package com.percyvega.testing.doubles;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import com.percyvega.testing.RandomIntsRepo;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by percy on 1/17/2016.
 */
public class AwesomeCalculatorMockitoMockTest {

    private static final int[] randomIntsFixtures = new int[] {3, 3, 3, 5, 5, 5};

    @Test
    public void shouldPredictAverageOfRandomInts() throws Exception {

        // given
        RandomIntsRepo mock = Mockito.mock(RandomIntsRepo.class);
        Mockito.when(mock.getRandomInts()).thenReturn(randomIntsFixtures);
        AwesomeCalculator calculator = new AwesomeCalculatorImpl(mock);

        // when
        int average = calculator.getAverageRandomInts();

        // then
        assertThat(average, is(4));
        System.out.println(average);
        Mockito.verify(mock).getRandomInts();

    }

}