package DataStructures.ListStackQueue;

import java.util.Iterator;

public class QueueListImp<T extends Comparable<T>> implements IQueue<T> {

    private IList<T> underlyingList;

    public QueueListImp() {
        underlyingList = new SinglyLinkedList<>();
    }

    public void enqueue(T element) {
        underlyingList.addLast(element);
    }

    public T dequeue() {
        if (isEmpty())
            return null;

        return underlyingList.removeFirst();
    }

    public int size() { return underlyingList.size(); }
    public boolean isEmpty() { return underlyingList.size() == 0; }
    public T peek() { return underlyingList.getHead().getValue(); }

    public Iterator<T> iterator() { return new QueueIterator(); }

    private class QueueIterator implements Iterator<T>
    {
        private Node<T> cur;
        private QueueIterator() { cur = underlyingList.getHead(); }
        public boolean hasNext() { return cur != null; }
        public void remove() { /* not supported */ }
        public T next() {
            T temp = cur.getValue();
            cur = cur.getNext();
            return temp;
        }
    }
}
