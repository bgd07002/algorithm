package DataStructures.ListStackQueue;

import java.util.Iterator;

public class ListIterator<T extends Comparable<T>> implements Iterator<T> {

    private IList<T> list;
    private Node<T> cur;

    public ListIterator(IList<T> list) {
        this.list = list;
        this.cur = list.getHead();
    }

    public boolean hasNext() {
        return cur != null;
    }

    public T next() {
        T returnedValue = cur.getValue();
        cur = cur.getNext();
        return returnedValue;
    }

    public void remove() {
        //By design
    }
}
