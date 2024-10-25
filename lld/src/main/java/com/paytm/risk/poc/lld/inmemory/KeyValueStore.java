package com.paytm.risk.poc.lld.inmemory;

public class KeyValueStore<K, V> {
    //Entry Class
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        int hash;

        public Entry(int hash, K key, V value, Entry<K, V> entry) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = entry;
        }
    }

    private Entry<K,V> [] table;


}
