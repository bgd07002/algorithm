package DataStructures.HeapPriorityQueue;

public interface IPriorityQueue<K,D> {

    int getSize();
    boolean isEmpty();
    Entry<K,D> extractMin();
    void insert(K key,D data);
    Entry<K,D> getMin();
}
