package com.percyvega.datastructure.hashtable;


import com.percyvega.datastructure.linkedlist.LinkedList;

/**
 * Created by percy on 4/16/2017.
 */
public class Hashtable<K, V> {

    public static int KEY_SET_SIZE = 200;

    private LinkedList<KeyValue>[] hashCodes = new LinkedList[KEY_SET_SIZE];
    private int size = 0;

    public void put(K key, V value) {
        int hashTableKey = getHashTableKey(key);

        if(hashCodes[hashTableKey] == null) {
            hashCodes[hashTableKey] = new LinkedList<>();
            size++;
        }

        hashCodes[hashTableKey].add(new KeyValue<>(key, value));
    }

    private int getHashTableKey(K key) {
        return Math.abs(key.hashCode()) % KEY_SET_SIZE;
    }

    public V get(K key) {
        int hashTableKey = getHashTableKey(key);

        if(hashCodes[hashTableKey] == null) {
            return null;
        }

        for (int i = 0; i < hashCodes[hashTableKey].size(); i++) {
            KeyValue<K, V> keyValue = hashCodes[hashTableKey].get(i);
            if(keyValue.key.equals(key))
                return keyValue.value;
        }

        return null;
    }

    public int size() {
        return size;
    }


}

class KeyValue<K, V> {
    K key;
    V value;

    KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }
}