package DataStructures.ListStackQueue;

import java.util.Iterator;

public class StackListImp<T extends Comparable<T>> implements IStack<T>, Iterable<T> {

    private IList<T> underlyingList;

    public StackListImp() {
        underlyingList = new SinglyLinkedList<>();
    }

    @Override
    public void push(T element) {
        underlyingList.addFirst(element);
    }

    @Override
    public T pop() {
        return underlyingList.removeFirst();
    }

    @Override
    public int size() {
        return underlyingList.size();
    }

    @Override
    public boolean isEmpty() {
        return underlyingList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>
    {
        private Node<T> cur;
        private StackIterator() { cur = underlyingList.getHead(); }
        public boolean hasNext() { return cur != null; }
        public void remove() { /* not supported */ }
        public T next() {
            T temp = cur.getValue();
            cur = cur.getNext();
            return temp;
        }
    }
}
