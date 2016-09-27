package DataStructures.HeapPriorityQueue;

public interface IHeap<K,D> {

    void insert(Entry<K,D> newEntry);
    D remove();
    int getSize();
    Entry<K,D> getMin();
    Entry<K,D> extractMin();
    String printHeap();
}
