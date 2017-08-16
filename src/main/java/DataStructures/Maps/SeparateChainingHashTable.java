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
    private int loadFactor;
    private static final int RESIZE_UPPER_BOUND = 8;
    private static final int RESIZE_LOWER_BOUND = 2;

    public SeparateChainingHashTable(int loadFactor) {
        this.loadFactor = loadFactor;
        bucketList = new ArrayList<>();
        for (int i = 0; i < this.loadFactor; i++)
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
        int bucketNumber = hashCode % loadFactor;
        return bucketList.get(bucketNumber);
    }

    @Override
    public void put(K key, T value) {
        List<Entry<K,T>> bucket = retrieveBucket(key);
        bucket.add(new Entry<>(key, value));
        size++;

        if (size / loadFactor >= RESIZE_UPPER_BOUND)
            resizeSepareteChaining();
    }

    @Override
    public T remove(K key) {
        List<Entry<K,T>> bucket = retrieveBucket(key);

        for (Entry<K,T> anEntry : bucket) {
            if (anEntry.getKey().equals(key)) {
                T value = anEntry.getValue();
                bucket.remove(anEntry);
                size--;

                if (size / loadFactor <= RESIZE_LOWER_BOUND)
                    resizeSepareteChaining();

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
        return sb.toString().trim();
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

    public void resizeSepareteChaining() {

        //Check first if resize necessary
        int threshold = size / loadFactor;

        int newLoadFactor;
        if (threshold >= RESIZE_UPPER_BOUND) {
            newLoadFactor = 2* loadFactor;

            //First add new buckets
            for (int i = 0; i< loadFactor; i++)
                bucketList.add(new LinkedList<>());

            rearrangeBuckets(newLoadFactor);
            loadFactor = newLoadFactor;
        }

        if (threshold <= RESIZE_LOWER_BOUND) {
            newLoadFactor = loadFactor /2;
            rearrangeBuckets(newLoadFactor);

            //Delete extra buckets
            for (int i=loadFactor-1; i >= newLoadFactor; i--)
                bucketList.remove(i);

            loadFactor = newLoadFactor;
        }

    }

    private void rearrangeBuckets(int newLoadFactor) {
        for (int i =0; i < loadFactor; i++) {
            for (int j=0; j < bucketList.get(i).size(); j++) {
                int hashCode = bucketList.get(i).get(j).getKey().hashCode();
                int newBucketNumber = hashCode % newLoadFactor;
                int existingBucketNumber = hashCode % loadFactor;
                if (newBucketNumber != existingBucketNumber) {
                    bucketList.get(newBucketNumber).add(bucketList.get(i).get(j));
                    bucketList.get(i).remove(j);
                    j--;
                }
            }
        }
    }
}
