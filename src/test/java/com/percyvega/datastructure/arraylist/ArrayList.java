package com.percyvega.datastructure.arraylist;

import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 4/15/2017.
 */
@Log4j2
public class ArrayList<T> {

    private T[] array;
    private int size = 0;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T s) {
        if (array.length == size) {
            T[] newArray = (T[]) new Object[array.length * 2];
            log.info("Doubling size, from " + array.length + " to " + newArray.length);
            copyFromTo(array, newArray);
            array = newArray;
        }

        array[size] = s;

        size++;
    }

    private void copyFromTo(T[] array, T[] newArray) {
        System.arraycopy(array, 0, newArray, 0, array.length);
    }

    public T get(int i) {
        return array[i];
    }

    public int size() {
        return size;
    }
}
