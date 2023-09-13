package com.percyvega.experiments.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class LowerBoundedWildcardTest {

    // This works too
//    private <T extends Number> void logSum(List<T> list) {
//        log.info(Arrays.toString(list.toArray()));
//    }

    private Double getSum(List<? super Integer> list) {
        return list.stream()
                .mapToDouble(o -> Double.parseDouble(o.toString()))
                .sum();
    }

    @Test
    void useListOfIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(getSum(list)).isEqualTo(15);
    }

    @Test
    void useListOfNumbers() {
        List<Number> list = Arrays.asList(1.1f, 2.1d, 3, 4L, new BigInteger("5"));
        assertThat(getSum(list)).isEqualTo(15.2);
    }

}
