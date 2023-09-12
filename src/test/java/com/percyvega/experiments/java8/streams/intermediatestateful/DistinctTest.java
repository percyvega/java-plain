package com.percyvega.experiments.java8.streams.intermediatestateful;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class DistinctTest {

    @Test
    void distinct() {
        List<Integer> integerList = Stream.of(2, 8, 8, 4, 4, 6, 7, 8, 8, 9, 9, 9)
                .distinct()
                .collect(Collectors.toList());

        assertThat(integerList).containsExactly(2, 8, 4, 6, 7, 9);
    }

}
