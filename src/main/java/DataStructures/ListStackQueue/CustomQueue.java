package DataStructures.ListStackQueue;

import java.util.LinkedList;

public class CustomQueue<T> implements IQueue<T> {

    LinkedList<T> underlyingList;

    public CustomQueue() {
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

    public T peek() { return underlyingList.getFirst(); }
}
