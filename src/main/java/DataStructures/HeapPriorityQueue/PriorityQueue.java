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
    public D extractMin() {
        return heap.extractMin();
    }

    @Override
    public void insert(K key, D data) {
        heap.insert(new Entry<K,D>(key,data));
    }

    @Override
    public D getMin() {
        return heap.getMin();
    }
}
