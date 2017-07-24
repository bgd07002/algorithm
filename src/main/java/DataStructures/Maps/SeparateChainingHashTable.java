package DataStructures.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Separate Chaining Implementation
 */
public class SeparateChainingHashTable<K,T> implements IMap<K,T> {

    private ArrayList<List<Entry<K,T>>> bucketList;
    private int size;
    private static final int LOAD_FACTOR = 5;

    public SeparateChainingHashTable() {
        bucketList = new ArrayList<>();
        for (int i=0; i < LOAD_FACTOR; i++)
            bucketList.add(new LinkedList<>());
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(K key) {
        List<Entry<K,T>> bucket = retrieveBucket(key);
        if (bucket == null)
            return null;

        for (Entry<K,T> anEntry : bucket) {
            if (anEntry.getKey().equals(key))
                return anEntry.getValue();
        }
        return null;
    }

    private List<Entry<K,T>> retrieveBucket(K key) {
        int hashCode = key.hashCode();
        int bucketNumber = hashCode % LOAD_FACTOR;
        return bucketList.get(bucketNumber);
    }

    @Override
    public void put(K key, T value) {
        List<Entry<K,T>> bucket = retrieveBucket(key);
        bucket.add(new Entry<>(key, value));
        size++;
    }

    @Override
    public T remove(K key) {
        List<Entry<K,T>> bucket = retrieveBucket(key);

        for (Entry<K,T> anEntry : bucket) {
            if (anEntry.getKey().equals(key)) {
                T value = anEntry.getValue();
                bucket.remove(anEntry);
                size--;
                return value;
            }
        }
        return null;
    }

    public Iterator<Entry<K,T>> getEntries() {
        return new MapIteratorSeparateChaining<>(bucketList);
    }

    @Override
    public String printKeys() {
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<K,T>> it = getEntries();

        while (it.hasNext()) {
            sb.append(it.next().getKey()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String printValues() {
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<K,T>> it = getEntries();

        while (it.hasNext()) {
            sb.append(it.next().getValue()).append(", ");
        }
        return sb.toString();
    }


    /*
    private ArrayList<List<Entry<K,T>>> bucketList;
    private int size;
    private final static int LOAD_FACTOR = 5;

    public SeparateChainingHashTable() {
        bucketList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private List<Entry<K,T>> retrieveBucket(K key) {
        int hashCode = key.hashCode();
        int bucketNumber = hashCode % LOAD_FACTOR;

        int idx = bucketList.size();
        while (idx <= bucketNumber) {
            bucketList.add(new LinkedList<>());
            idx++;
        }
        return bucketList.get(bucketNumber);
    }

    @Override
    public T get(K key) {
        List<Entry<K,T>> bucket = retrieveBucket(key);
        if (bucket == null)
            return null;

        for (Entry<K,T> anEntry : bucket) {
            if (anEntry.getKey().equals(key))
                return anEntry.getValue();
        }
        return null;
    }

    @Override
    public void put(K key, T value) {
        List<Entry<K,T>> bucket = retrieveBucket(key);

        if (bucket == null)
            bucket = new LinkedList<>();

        for (Entry<K,T> anEntry : bucket) {
            if (anEntry.getKey().equals(key)) {
                anEntry.setValue(value);
                return;
            }
        }
        bucket.add(new Entry<>(key,value));
        size++;
    }

    @Override
    public T remove(K key) {
        List<Entry<K,T>> bucket = retrieveBucket(key);

        if (bucket == null)
            return null;

        for (Entry<K,T> anEntry : bucket) {
            if (anEntry.getKey().equals(key)) {
                T value = anEntry.getValue();
                bucket.remove(anEntry);
                size--;
                return value;
            }
        }
        return null;
    }

    public Iterator<Entry<K,T>> getEntries() {
        return new MapIteratorSeparateChaining<>(bucketList);
    }

    @Override
    public String printKeys() {
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<K,T>> it = getEntries();

        while (it.hasNext()) {
            sb.append(it.next().getKey()).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String printValues() {
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<K,T>> it = getEntries();

        while (it.hasNext()) {
            sb.append(it.next().getValue()).append(", ");
        }
        return sb.toString();
    }
    */
}
