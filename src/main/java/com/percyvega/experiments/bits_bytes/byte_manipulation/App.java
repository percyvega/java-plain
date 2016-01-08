package com.percyvega.experiments.bits_bytes.byte_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static final int AGE = 300;

    public static void main(String... args) throws IOException, ClassNotFoundException {

        ImmutablePerson person = new ImmutablePerson("Percy", "Vega", AGE);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        logger.debug(String.valueOf(byteArrayOutputStream.toByteArray().length));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        logger.debug(String.valueOf(byteArrayOutputStream.toByteArray().length));
        objectOutputStream.writeObject(person);
        logger.debug(String.valueOf(byteArrayOutputStream.toByteArray().length));
        objectOutputStream.close();

        byte[] bytes = byteArrayOutputStream.toByteArray();
        int index = -1;
        StringBuilder stringBuilderChars = new StringBuilder();
        StringBuilder stringBuilderIntsChars = new StringBuilder();
        StringBuilder stringBuilderInts = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            stringBuilderChars.append((char) bytes[i]);
            stringBuilderIntsChars.append(bytes[i] + "/" + (char) bytes[i] + " ");
            stringBuilderInts.append(bytes[i] + " ");
            if (bytes[i] == (byte) (AGE >>> 24) && bytes[i + 1] == (byte) (AGE >>> 16) && bytes[i + 2] == (byte) (AGE >>> 8) && bytes[i + 3] == (byte) AGE) {
                if (index == -1) {
                    index = i;
                } else {
                    throw new IllegalStateException("Duplicate index");
                }
            }
        }

        logger.debug(stringBuilderChars.toString());
        logger.debug(stringBuilderIntsChars.toString());
        logger.debug(stringBuilderInts.toString());

        int dogAge = AGE * 5;
        setAge(bytes, index, dogAge);

        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bytes));
        ImmutablePerson anotherPerson = (ImmutablePerson) oin.readObject();
        System.out.println("Age as a person: " + person);
        System.out.println("Age as a dog   : " + anotherPerson);
    }

    private static void setAge(byte[] bytes, int index, int age) {
        bytes[index] = (byte) (age >>> 24);
        bytes[index + 1] = (byte) (age >>> 16);
        bytes[index + 2] = (byte) (age >>> 8);
        bytes[index + 3] = (byte) age;
    }

}