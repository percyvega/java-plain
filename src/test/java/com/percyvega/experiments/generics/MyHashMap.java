package com.percyvega.experiments.generics;

import java.util.HashMap;

public class MyHashMap<K, V> extends HashMap<K, V> {

    public static <K, V> HashMap<K, V> newInstance() {
        return new HashMap<>();
    }

}
