package com.percyvega.experiments.hashcode;

/**
 * Created by percy on 4/16/2017.
 */
public class AppHashcode {

    public static void main(String[] args) {
        Integer i1 = 10;
        Long l1 = 10L;
        String s1 = String.valueOf(10);
        StringBuffer sb1 = new StringBuffer(String.valueOf(10));
        StringBuilder sbd1 = new StringBuilder(String.valueOf(10));
        Float f1 = 10f;
        Double d1 = 10d;

        Integer i2 = 100;
        Long l2 = 100L;
        String s2 = String.valueOf(100);
        StringBuffer sb2 = new StringBuffer(String.valueOf(100));
        StringBuilder sbd2 = new StringBuilder(String.valueOf(100));
        Float f2 = 100f;
        Double d2 = 100d;

        System.out.println(i1.hashCode() + ", " + i2.hashCode());
        System.out.println(l1.hashCode() + ", " + l2.hashCode());
        System.out.println(s1.hashCode() + ", " + s2.hashCode());
        System.out.println(sb1.hashCode() + ", " + sb2.hashCode());
        System.out.println(sbd1.hashCode() + ", " + sbd2.hashCode());
        System.out.println(f1.hashCode() + ", " + f2.hashCode());
        System.out.println(d1.hashCode() + ", " + d2.hashCode());
    }
}
