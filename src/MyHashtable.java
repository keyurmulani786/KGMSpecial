
import java.util.*;

public class MyHashtable<K, V> {

    final private int capacity = 20;
    final private Entry<K, V>[] myTable;

    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable<String, String>()).run();
    }

    /*
     we crate Entry class for insertion for key.
     we use static keyword for class because we need to load this class 
     when main class MyHashTable is loading.
    
     Example:
    
     0->(key-value)->(key-value)->(key-value)
     1->(key-value)
     2->(key-value)->(key-value)
     3
     .
     .
     19->(key-value)->(key-value)->(key-value)->(key-value)
     
    */
    static class Entry<K, V> {

        Entry<K, V> next;
        K key;
        V value;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashtable() {
        myTable = new Entry[capacity];
    }

    /*
     we take key.hashCode() for setting key in bucket based on capacity 
     here we take 20 capacity bucket so we set 0-19 block in bucket.
     if Math.abs(key.hashCode) is 1 then we set in 1 number bucket and
     is 20 then set in 0 number bucket block.
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        // TODO implement
        if (key == null) {
            throw new NullPointerException("Null key should not allowed.");
        }

        int hash = hash(key);

        Entry<K, V> entry = new Entry<>(key, value, null);

        if (myTable[hash] == null) {
            myTable[hash] = entry;
        } else {
            Entry<K, V> curr = myTable[hash];
            Entry<K, V> prev = null;

            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        entry.next = curr.next;
                        myTable[hash] = entry;
                        return;
                    } else {
                        entry.next = curr.next;
                        prev.next = entry;
                        return;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = entry;
        }

    }

    public V get(K key) {
        // TODO implement
        int hash = hash(key);
        if (myTable[hash] != null) {
            Entry<K, V> a = myTable[hash];
            while (a != null) {
                if (a.key.equals(key)) {

                    return a.value;
                }
                a = a.next;

            }
        } else {
            return null;
        }
        return null;

    }

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from
     * STDIN.
     */
    public static class TestHarness implements Runnable {

        final MyHashtable<String, String> hashtable;

        public TestHarness(MyHashtable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                System.out.println(" V:::" + v);
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
}
