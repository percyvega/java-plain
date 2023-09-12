package com.percyvega.experiments.java8.lambdascopes;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class FieldsAndStaticVariablesTest {

    static int outerStaticNum;
    int outerNum;

    @Test
    void lambdaScopesTest() {
        // int outerNum = 10; // when using a local variable modifying it inside the lambda won't compile.
        // It has to be effectively final, or a member variable or static.
        outerNum = 10;
        outerStaticNum = 20;
        Function<Integer, String> stringConverter1 = i -> String.valueOf(i + ++outerNum + ++outerStaticNum);

        outerNum = 30;
        outerStaticNum = 60;

        assertThat(stringConverter1.apply(10)).isEqualTo("102");
    }

}
