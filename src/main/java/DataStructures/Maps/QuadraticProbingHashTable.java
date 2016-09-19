package DataStructures.Maps;

public class QuadraticProbingHashTable<K,T> implements IMap<K,T>{

    private int currentSize, maxSize;
    private K[] keys;
    private T[] vals;

    public QuadraticProbingHashTable(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = (K[]) new Object[capacity];
        vals = (T[]) new Object[capacity];
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public T get(K key) {
        int i = hash(key), h = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key))
                return vals[i];
            i = (i + h * h++) % maxSize;
        }
        return null;
    }

    /**
     * Function to get hash code of a given key
     */
    private int hash(K key) {
        return key.hashCode() % maxSize;
    }

    @Override
    public void put(K key, T value) {

        int tmp = hash(key);
        int i = tmp, h = 1;
        do {
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = value;
                currentSize++;
                break;
            }
            if (keys[i].equals(key)) {
                vals[i] = value;
                break;
            }
            i = (i + h * h++) % maxSize;
        } while (i != tmp);
    }

    @Override
    public T remove(K key) {
        int i = hash(key), h = 1;
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                T temp = vals[i];
                keys[i] = null;
                vals[i] = null;
                currentSize--;
                return temp;
            }
            i = (i + h * h++) % maxSize;
        }
        return null;
    }

    @Override
    public String printKeys() {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < keys.length; i++) {
            if (keys[i] != null)
                sb.append(keys[i]).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String printValues() {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < vals.length; i++) {
            if (vals[i] != null)
                sb.append(vals[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
