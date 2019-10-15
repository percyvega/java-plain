package com.percyvega.experiments.ooo.polimorphism;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
public class Child4 extends Parent4 {

    // throws exception must be identical to parent's
    public void throwsCheckedException(String path, String text) throws IOException {
        FileWriter writer = new FileWriter(path, true);
        writer.write(text);
        writer.close();
    }

    // compiles well even though the RuntimeException has not been declared
    public void throwsRuntimeException(Object canBeNull) {
        System.out.println(canBeNull.toString());
    }

}

@Log4j2
class Parent4 {

    public void throwsCheckedException(String path, String text) throws IOException {
        FileWriter writer = new FileWriter(path, true);
        writer.write(text);
        writer.close();
    }

    public void throwsRuntimeException(Object canBeNull) throws NullPointerException {
        System.out.println(canBeNull.toString());
    }

}
