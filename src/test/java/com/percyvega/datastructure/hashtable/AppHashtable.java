package com.percyvega.datastructure.hashtable;


import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;

public class AppHashtable {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable();

        DataFactory df = new DataFactory();

        List<String> keys = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            String name = df.getName();
            String key = name + i;
            hashtable.put(key, name);

            if (i % 23 == 0) {
                keys.add(key);
            }
        }

        System.out.println("Key set size: " + Hashtable.KEY_SET_SIZE);
        System.out.println("Key table: " + hashtable.size());

        for (String key : keys) {
            System.out.println(hashtable.get(key));
        }
    }

}
