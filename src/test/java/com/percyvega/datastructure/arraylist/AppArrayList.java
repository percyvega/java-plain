package com.percyvega.datastructure.arraylist;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(2);
        ArrayList<String> arrayList2 = new ArrayList<>(2);

        for (int i = 0; i < 32; i++) {
            arrayList1.add(i);
            arrayList2.add("Element " + i);
        }

        for (int i = 0; i < arrayList1.size(); i++) {
            log.info(arrayList1.get(i) + ", " + arrayList2.get(i));
        }
    }

}
