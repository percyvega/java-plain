package com.percyvega.experiments.serialization.model;

import com.percyvega.experiments.encryption.EncryptionUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.time.Month;

@Data
public class PersonWithReadAndWriteObject implements Serializable {

    @Serial
    private static final long serialVersionUID = 97689145768L;

    private String firstName;
    private String lastName;
    private String password;
    @EqualsAndHashCode.Include
    private transient String fullName;
    private MySingleton mySingleton = MySingleton.getInstance();
    private Month favoriteMonth = Month.JANUARY;

    public PersonWithReadAndWriteObject(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.fullName = this.firstName + " " + this.lastName;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        try {
            setPassword(EncryptionUtil.encrypt(getPassword()));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }

        oos.defaultWriteObject();
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        try {
            setPassword(EncryptionUtil.decrypt(getPassword()));
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }

        setFullName(getFirstName() + " " + getLastName());
    }

}
