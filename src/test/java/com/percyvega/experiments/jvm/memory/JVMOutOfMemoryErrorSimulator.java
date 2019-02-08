package com.percyvega.experiments.jvm.memory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JVMOutOfMemoryErrorSimulator {

    private final static int NB_ITERATIONS = 500000;

    // ~1 KB data footprint
    private final static String BIG_STRING =
            "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
                    + "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012";

    // Map used to stored our leaking String instances
    private static Map<String, String> map1;
    private static Map<String, String> map2;
    private static Map<String, String> map3;
    private static Map<String, String> map4;

    static {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new LinkedHashMap<>();
        map4 = new LinkedHashMap<>();
    }

    public static void main(String[] args) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ObjectOutputStream oOut;
        try {
            oOut = new ObjectOutputStream(bOut);
            String jedi = BIG_STRING;
            oOut.writeObject(jedi);
            oOut.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("The size in bytes of the object (before appending 7 characters) is: " + (bOut.toByteArray().length - 7));

        int i = 0;
        try {
            for (; i < NB_ITERATIONS; i++) {
                String s = String.format("%06d", i);
                String data1 = BIG_STRING + 1 + s;
                String data2 = BIG_STRING + 2 + s;
                String data3 = BIG_STRING + 3 + s;
                String data4 = BIG_STRING + 4 + s;
                if (i % 10000 == 0) {
                    System.out.println("Stored the first " + s + " elements in map1 with data: " + data1);
                    System.out.println("Stored the first " + s + " elements in map2 with data: " + data2);
                    System.out.println("Stored the first " + s + " elements in map3 with data: " + data3);
                    System.out.println("Stored the first " + s + " elements in map4 with data: " + data4);
                }
                // Add data to our leaking Map data structure...
                map1.put(data1, data1);
                map2.put(data2, data2);
                map3.put(data3, data3);
                map4.put(data4, data4);
            }
        } catch (Throwable e) {
            if (e instanceof java.lang.OutOfMemoryError) {
                System.out.println("OutOfMemoryError triggered! " + e.getMessage() + " [" + e + "]");
            } else {
                System.out.println("Unexpected Exception! " + e.getMessage() + " [" + e + "]");
            }
            System.out.println("Final value of i: " + i);
        }

        System.out.println("simulator done!");
    }

}
