package com.percyvega.experiments.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Log4j2
public class AppConstructors {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = new Person("Percy", 39);

        Class<?> aClass = person.getClass();

        log.info(aClass.getName());

        Constructor<?>[] constructors = aClass.getConstructors();
        log.info("Constructor count: " + constructors.length);

        Object fran = constructors[0].newInstance("Fran", 31);
        log.info(((Person) fran).getName());
        log.info(((Person) fran).getAge());
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private int age;
}
