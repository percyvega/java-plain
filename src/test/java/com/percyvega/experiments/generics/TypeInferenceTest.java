package com.percyvega.experiments.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

@Log4j2
class TypeInferenceTest {

    @Test
    void test() {
        MyClass<String> myClass = new MyClass<>(4);

        log.info(myClass.getX());

        myClass.getList().forEach(log::info);
    }

}


class MyClass<X> {

    private final X x;

    <T> MyClass(T t) {
        x = (X) t.toString();
    }

    X getX() {
        return x;
    }

    public List<X> getList() {
        return List.of(x);
    }
}
