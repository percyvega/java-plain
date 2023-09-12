package com.percyvega.experiments.java8.interfaces;

import com.percyvega.experiments.java8.interfaces.model.DefaultMethodInterfacePerson;
import com.percyvega.experiments.java8.interfaces.model.Person;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class DefaultMethodInterfacePersonTest {

    @Test
    void testDefaultMethod() {
        Person aPerson = new Person();

        assertThat(aPerson.toString()).isEqualTo("Percy is a male");
    }

    @Test
    void testStaticMethod() {
        assertThat(DefaultMethodInterfacePerson.countNameCharacters(new Person())).isEqualTo(5);
    }

}
