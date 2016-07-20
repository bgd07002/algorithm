package DataStructures.ListStackQueue;

public interface IQueue<T> {
    void enqueue(T element);
    T dequeue();
    int size();
    boolean isEmpty();
}
