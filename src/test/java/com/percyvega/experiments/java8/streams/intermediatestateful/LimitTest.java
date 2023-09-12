package com.percyvega.experiments.java8.streams.intermediatestateful;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class LimitTest {

    static List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    void testLimit() {

        assertThat(integerList.stream()
                .limit(4)
                .count()
        ).isEqualTo(4);

        assertThat(integerList.stream()
                .limit(4)
                .mapToInt(Integer::intValue)
                .sum()
        ).isEqualTo(10);
    }

}
