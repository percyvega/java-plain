package com.percyvega.experiments.serialization;

import com.percyvega.experiments.encryption.EncryptionUtil;
import com.percyvega.experiments.serialization.model.Person;
import com.percyvega.experiments.serialization.model.PersonWithReadAndWriteObject;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.*;
import java.security.InvalidKeyException;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class SerializationTest {

    private static final String FILE_NAME = "person.ser";
    public static final String FIRST_NAME = "Percy";
    public static final String LAST_NAME = "Vega";
    public static final String PASSWORD = "my password";
    public static final String FULL_NAME = "Percy Vega";

    @Test
    void hashCodesNotEqual_and_objectsNotEqual() throws IOException, ClassNotFoundException {
        Person person = new Person(FIRST_NAME, LAST_NAME, PASSWORD);

        assertThat(person.getFullName()).isEqualTo(FULL_NAME);

        Person deserializedPerson = serializeAndGetDeserialized(person);

        assertThat(person.getFirstName()).isEqualTo(deserializedPerson.getFirstName());
        assertThat(person.getLastName()).isEqualTo(deserializedPerson.getLastName());
        assertThat(person.getPassword()).isEqualTo(deserializedPerson.getPassword());
        assertThat(person.getFullName()).isEqualTo(FULL_NAME);
        assertThat(deserializedPerson.getFullName()).isNull(); // while deserializing using the defaultReadObject, fullName was not set.
        assertThat(person.getMySingleton()).isEqualTo(deserializedPerson.getMySingleton()); // it would be a different instance of MySingleton, but it implemented readResolve()
        assertThat(person.getFavoriteMonth()).isEqualTo(deserializedPerson.getFavoriteMonth());
    }

    @Test
    void when_readObjectIsImplemented_hashCodesEqual_and_objectsEqual() throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        PersonWithReadAndWriteObject person = new PersonWithReadAndWriteObject(FIRST_NAME, LAST_NAME, PASSWORD);

        assertThat(person.getFullName()).isEqualTo(FULL_NAME);

        PersonWithReadAndWriteObject deserializedPerson = serializeAndGetDeserialized(person);

        assertThat(person.getFirstName()).isEqualTo(deserializedPerson.getFirstName());
        assertThat(person.getLastName()).isEqualTo(deserializedPerson.getLastName());
        assertThat(person.getPassword()).isEqualTo(EncryptionUtil.encrypt(PASSWORD)); // while serializing using writeObject, password was encrypted.
        assertThat(deserializedPerson.getPassword()).isEqualTo(PASSWORD);
        assertThat(person.getFullName()).isEqualTo(deserializedPerson.getFullName());
        assertThat(person.getMySingleton()).isEqualTo(deserializedPerson.getMySingleton());  // it would be a different instance of MySingleton, but it implemented readResolve()
        assertThat(person.getFavoriteMonth()).isEqualTo(deserializedPerson.getFavoriteMonth());
    }

    @SuppressWarnings("unchecked")
    private static <T> T serializeAndGetDeserialized(T person) throws IOException, ClassNotFoundException {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(person);
        }

        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (T) ois.readObject();
        }
    }

}
