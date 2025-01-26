package com.percyvega.experiments.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
class ClassLevelTypeVariableClass<T> {

    private final T[] array;
    private int index = 0;

    ClassLevelTypeVariableClass(int count) {
        array = (T[]) new Object[count];
    }

    void add(T element) {
        array[index++] = element;
    }

    T get(int position) {
        return array[position];
    }

    int size() {
        return array.length;
    }

    // This method's P has nothing to do with the class' T.
    // I could have used T for this method, or any other method level type letter (instead of P or T)
    static <P> P echoParam(P p) {
        return p;
    }
}

@Log4j2
class ClassLevelTypeVariableClassTest {

    @Test
    void testInstantiation() {
        ClassLevelTypeVariableClass<Integer> classLevelTypeVariableClass = new ClassLevelTypeVariableClass<>(64);
        classLevelTypeVariableClass.add(3);
        classLevelTypeVariableClass.add(2);
        classLevelTypeVariableClass.add(6);

        assertThat(classLevelTypeVariableClass.get(0)).isEqualTo(3);
        assertThat(classLevelTypeVariableClass.get(1)).isEqualTo(2);
        assertThat(classLevelTypeVariableClass.get(2)).isEqualTo(6);
        assertThat(classLevelTypeVariableClass.get(3)).isNull();

        String s = ClassLevelTypeVariableClass.echoParam("Percy");
        assertThat(s).isEqualTo("Percy");
    }

}
