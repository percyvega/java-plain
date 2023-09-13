package com.percyvega.experiments.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class UnboundedWildcardsTest {

    // Does NOT work
//    private void printList(List<Object> list) {
//        log.info(Arrays.toString(list.toArray()));
//    }

    private String getListOfStrings(List<?> list) {
        return Arrays.toString(list.toArray());
    }

    @Test
    void useListOfIntegers() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(getListOfStrings(list)).isEqualTo("[1, 2, 3, 4, 5]");
    }

    @Test
    void useListOfStrings() {
        List<String> list = Arrays.asList("January", "February", "March");
        assertThat(getListOfStrings(list)).isEqualTo("[January, February, March]");
    }

}
