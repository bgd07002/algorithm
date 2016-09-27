package DataStructures.HeapPriorityQueue;


public class Entry<K,D> {

    private K key;
    private D value;

    public Entry(K key, D value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public D getValue() {
        return value;
    }

    public void setValue(D value) {
        this.value = value;
    }
}
