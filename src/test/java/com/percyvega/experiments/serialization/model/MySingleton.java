package com.percyvega.experiments.serialization.model;

import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

public class MySingleton implements Serializable {

    private static final MySingleton INSTANCE = new MySingleton();

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        return INSTANCE;
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

}
