package com.percyvega.experiments.java8.interfaces;

import com.percyvega.experiments.java8.interfaces.model.SamInterface;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SamInterfaceTest {

    @Test
    void nonFunctional() {
        SamInterface samInterface = new SamInterface() {
            @Override
            public String doSomething(String s) {
                return s.toUpperCase();
            }
        };

        assertThat(samInterface.doSomething("Hello!")).isEqualTo("HELLO!");
    }

    @Test
    void lambda_1() {
        SamInterface samInterface = (String s) -> s.toLowerCase();

        assertThat(samInterface.doSomething("Hello!")).isEqualTo("hello!");
    }

    @Test
    void lambda_2() {
        SamInterface samInterface = (s) -> String.valueOf(s.length());

        assertThat(samInterface.doSomething("Hello!")).isEqualTo("6");
    }

    @Test
    void lambda_3() {
        SamInterface samInterface = s -> String.valueOf(s.length());

        assertThat(samInterface.doSomething("Hello!")).isEqualTo("6");
    }

    @Test
    void methodReference() {
        SamInterface samInterface = String::toLowerCase;

        assertThat(samInterface.doSomething("Hello!")).isEqualTo("hello!");
    }

}