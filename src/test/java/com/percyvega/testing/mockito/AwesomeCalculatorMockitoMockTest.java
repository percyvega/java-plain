package com.percyvega.testing.mockito;

import com.percyvega.testing.AwesomeCalculator;
import com.percyvega.testing.AwesomeCalculatorImpl;
import com.percyvega.testing.RandomIntsRepo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by percy on 1/17/2016.
 */
@Log4j2
public class AwesomeCalculatorMockitoMockTest {

    private static final int[] randomIntsFixtures = new int[]{3, 3, 3, 5, 5, 5};

    @Test
    public void shouldPredictAverageOfRandomInts() throws Exception {

        // given
        RandomIntsRepo mock = Mockito.mock(RandomIntsRepo.class);
        Mockito.when(mock.getRandomInts()).thenReturn(randomIntsFixtures);
        AwesomeCalculator calculator = new AwesomeCalculatorImpl(mock);

        // when
        int average = calculator.getAverageRandomInts();

        // then
        assertThat(average).isEqualTo(4);
        log.info(average);
        Mockito.verify(mock).getRandomInts();

    }

}
