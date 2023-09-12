package com.percyvega.experiments.java8.lambdascopes;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class DefaultInterfaceMethodsTest {

    @FunctionalInterface
    interface Calculator {
        double calculate(int x, int y);

        static double sqrt(int x) {
            return Math.sqrt(x);
        }

        default double square(int x) {
            return Math.pow(x, 2);
        }
    }

    @Test
    void test1() {
        Calculator calculator = new Calculator() {
            @Override
            public double calculate(int x, int y) {
                return x + y;
            }

            @Override
            public double square(int x) {
                return x * x;
            }

            // inaccessible because this inner class' interface doesn't define it
            public double cube(int x) {
                return x * x * x;
            }
        };

        assertThat(calculator.calculate(100, 13)).isEqualTo(113);
        assertThat(calculator.square(13)).isEqualTo(169);

        assertThat(Calculator.sqrt(16)).isEqualTo(4);
    }

    @Test
    void test2() {
        Calculator calculator = (x, y) -> x - y;
        assertThat(calculator.calculate(100, 13)).isEqualTo(87);
    }

    @Test
    void test3() {
        Calculator calculator = (x, y) -> Calculator.sqrt(x + y);
        assertThat(calculator.calculate(60, 4)).isEqualTo(8);
    }

    @Test
    void test4() {
        Calculator calculator = (x, y) -> x * 1.0 / y;
        assertThat(calculator.calculate(100, 20)).isEqualTo(5);
    }

}
