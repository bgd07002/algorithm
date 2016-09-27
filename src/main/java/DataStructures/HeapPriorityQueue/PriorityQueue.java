package DataStructures.HeapPriorityQueue;

public class PriorityQueue<K,D> implements IPriorityQueue<K,D> {

    private IHeap<K,D> heap;

    public PriorityQueue(IHeap<K, D> heap) {
        this.heap = heap;
    }

    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.getSize() == 0;
    }

    @Override
    public Entry<K,D> extractMin() {
        return heap.extractMin();
    }

    @Override
    public void insert(K key, D data) {
        heap.insert(new Entry<>(key,data));
    }

    @Override
    public Entry<K,D> getMin() {
        return heap.getMin();
    }
}
