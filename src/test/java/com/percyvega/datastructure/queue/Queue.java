package com.percyvega.datastructure.queue;

/**
 * Created by percy on 4/29/2017.
 */
public class Queue<T> {

    private Item<T> first;
    private Item<T> last;

    public void add(T data) {
        Item<T> newItem = new Item<>(data);

        if (!isEmpty()) {
            last.next = newItem;
        } else {
            first = newItem;
        }

        last = newItem;
    }

    public T remove() {
        if (!isEmpty()) {
            T data = first.data;

            if (first.next != null) {
                first = first.next;
            } else {
                last = null;
            }

            return data;
        } else {
            throw new NullPointerException("Queue is isEmpty. remove is not allowed.");
        }
    }

    public T peek() {
        return first.data;
    }

    public boolean isEmpty() {
        return first == null || last == null;
    }

}

class Item<T> {

    T data;
    Item<T> next;

    Item(T data) {
        this.data = data;
    }
}