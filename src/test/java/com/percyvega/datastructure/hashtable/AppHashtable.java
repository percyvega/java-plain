package com.percyvega.datastructure.hashtable;


import lombok.extern.log4j.Log4j2;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;

@Log4j2
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

        log.info("Key set size: " + Hashtable.KEY_SET_SIZE);
        log.info("Key table: " + hashtable.size());

        for (String key : keys) {
            log.info(hashtable.get(key));
        }
    }

}
