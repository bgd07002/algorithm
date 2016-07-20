package DataStructures.HeapPriorityQueue;

public interface IPriorityQueue<K,D> {

    int getSize();
    boolean isEmpty();
    D extractMin();
    void insert(K key,D data);
    D getMin();
}
