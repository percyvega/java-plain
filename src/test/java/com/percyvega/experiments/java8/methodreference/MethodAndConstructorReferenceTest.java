package com.percyvega.experiments.java8.methodreference;

import com.percyvega.experiments.java8.model.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class MethodAndConstructorReferenceTest {

    @Test
    void methodReferenceTest() {
        IntFunction<String> fromIntToString = Integer::toString;
        log.info("fromIntToString: " + fromIntToString.apply(23));

        Function<String, BigInteger> fromStringToBigInteger = BigInteger::new;
        log.info(fromStringToBigInteger.apply("1234567890123456"));

        Consumer<String> consumer = log::info;
        consumer.accept("Message to print out");

        UnaryOperator<String> unaryOperator = "Hello "::concat;
        log.info(unaryOperator.apply("Percy!"));
    }

    @Test
    void function_as_a_parameter() {
        Function<String, Integer> valueOf = Integer::valueOf;
        assertThat(functionApplyToString(valueOf, "23") + 4).isEqualTo(27);

        assertThat(functionApplyToString(Integer::valueOf, "23") + 4).isEqualTo(27);
    }

    private Integer functionApplyToString(Function<String, Integer> function, String s) {
        return function.apply(s);
    }

    @Test
    void supplier_as_a_parameter() {
        Random random = new Random();
        Supplier<Integer> nextInt = random::nextInt;
        for (int i = 0; i < 10; i++) {
            assertThat(supplierGet(nextInt)).isLessThanOrEqualTo(Integer.MAX_VALUE).isGreaterThanOrEqualTo(Integer.MIN_VALUE);
        }
    }

    private Integer supplierGet(Supplier<Integer> supplier) {
        return supplier.get();
    }

    @Test
    void no_arguments_constructor_reference_test() {
        Supplier<Student> studentSupplier = Student::new;
        assertThat(studentSupplier.get()).isInstanceOf(Student.class);
    }

    @Test
    void one_arguments_constructor_reference_test() {
        Function<String, Student> studentFunction = Student::new;

        assertThat(studentFunction.apply("Percy").getName()).isEqualTo("Percy");
    }

}
