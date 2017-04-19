package com.percyvega.datastructure.linkedlist;

/**
 * Created by percy on 4/16/2017.
 */
public class LinkedList<E> {

    private int size = 0;
    private Element head;
    private Element tail;

    public int size() {
        return size;
    }

    public void add(E element) {
        Element<E> newElement = new Element<>(element);
        if(size == 0) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;
        }

        size++;
    }

    public E get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is " + index + " and size is " + size);

        Element<E> element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.value;
    }
}

class Element<E> {
    Element<E> prev;
    E value;
    Element<E> next;

    Element(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
