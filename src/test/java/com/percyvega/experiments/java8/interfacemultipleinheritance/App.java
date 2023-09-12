package com.percyvega.experiments.java8.interfacemultipleinheritance;

import com.percyvega.experiments.java8.interfacemultipleinheritance.model.CousinCoworker;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class App {

    @Test
    void testFunctionalInterface() {
        CousinCoworker cousinCoworker = new CousinCoworker();

        assertThat(cousinCoworker.getName()).isEqualTo("Percy Vega");
        assertThat(cousinCoworker.getRole()).isEqualTo("Father/Manager");
        assertThat(cousinCoworker.getSalute("Percy")).isEqualTo("Good morning, Percy");
    }

}