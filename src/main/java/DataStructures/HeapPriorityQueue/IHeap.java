package DataStructures.HeapPriorityQueue;

public interface IHeap<K,D> {

    void insert(Entry<K,D> newEntry);
    D remove();
    int getSize();
    D getMin();
    D extractMin();
    String printHeap();
}
