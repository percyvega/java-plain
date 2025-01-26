package com.percyvega.experiments.generics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

interface MythologicalCharacter {
    String getOrigin();
}

interface Superhero {
    String getPublisher();
}

class ComicCharacter {
    boolean isFictitious() {
        return true;
    }
}

abstract class CharacterWithGender {
    abstract String getGender();
}

class Thor extends ComicCharacter implements MythologicalCharacter, Superhero {
    @Override
    public String getOrigin() {
        return "Germanic";
    }

    @Override
    public String getPublisher() {
        return "DC";
    }
}

class Superman extends CharacterWithGender implements Superhero {
    @Override
    public String getPublisher() {
        return "Marvel";
    }

    @Override
    String getGender() {
        return "Male";
    }
}

@Log4j2
class ComicsUtil {

    // extends 1 class and 2 interfaces!!! You must start specifying with classes then interfaces
    static <T extends ComicCharacter & MythologicalCharacter & Superhero> String getOriginAndPublisher(T t) {
        return t.getOrigin() + ", " + t.getPublisher();
    }

    // extends an interface
    static <T extends Superhero> String getPublisher(T t) {
        return t.getPublisher();
    }

    // extends an interface
    static <T extends ComicCharacter> boolean getIsFictitious(T t) {
        return t.isFictitious();
    }

    // extends a class!!!
    static <T extends CharacterWithGender> String getGender(T t) {
        return t.getGender();
    }
}

@Log4j2
class BoundedTypeParameterTest {

    @Test
    void testThor() {
        Thor thor = new Thor();

        assertThat(ComicsUtil.getOriginAndPublisher(thor)).isEqualTo("Germanic, DC");
        assertThat(ComicsUtil.getPublisher(thor)).isEqualTo("DC");
        assertThat(ComicsUtil.getIsFictitious(thor)).isEqualTo(true);
    }

    @Test
    void testSuperman() {
        Superman superman = new Superman();

        assertThat(ComicsUtil.getPublisher(superman)).isEqualTo("Marvel");
        assertThat(ComicsUtil.getGender(superman)).isEqualTo("Male");
    }
}
