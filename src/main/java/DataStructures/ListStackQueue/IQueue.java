package DataStructures.ListStackQueue;

import java.util.Iterator;

public interface IQueue<T> {
    void enqueue(T element);
    T dequeue();
    int size();
    boolean isEmpty();
    Iterator iterator();
    T peek();
}
