package DataStructures.ListStackQueue;

import java.util.LinkedList;

public class Queue<T> implements IQueue<T> {

    LinkedList<T> underlyingList;

    public Queue() {
        underlyingList = new LinkedList<T>();
    }

    public void enqueue(T element) {
        underlyingList.add(element);
    }

    public T dequeue() {
        if (isEmpty())
            return null;

        return underlyingList.removeFirst();
    }

    public int size() {
        return underlyingList.size();
    }

    public boolean isEmpty() {
        return underlyingList.size() == 0;
    }
}
