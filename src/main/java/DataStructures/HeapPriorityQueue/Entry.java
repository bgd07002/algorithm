package DataStructures.HeapPriorityQueue;


public class Entry<K,D> {

    private K key;
    private D value;
    private int index;

    public Entry(K key, D value) {
        this.key = key;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
