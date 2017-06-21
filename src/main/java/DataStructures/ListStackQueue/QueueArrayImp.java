package DataStructures.ListStackQueue;

import java.util.Iterator;

public class QueueArrayImp<T> implements IQueue<T>{

    private T[] underlyingArr;
    private int size;
    private static final int DEFAULTSIZE = 10;

    public QueueArrayImp() {
        this(DEFAULTSIZE);
    }

    public QueueArrayImp(int initialSize) {
        underlyingArr = (T[]) new Object[initialSize];
    }

    @Override
    public void enqueue(T element) {
        if (size == underlyingArr.length-1) {
            T[] newArr = (T[]) new Object[size * 2];
            System.arraycopy(underlyingArr, 0, newArr, 0, size);
            underlyingArr = newArr;
        }
        underlyingArr[size++] = element;
    }

    @Override
    public T dequeue() {
        if (size == 0)
            return null;

        T temp = underlyingArr[0];
        for (int i = 1; i < size; i++ )
            underlyingArr[i-1] = underlyingArr[i];

        underlyingArr[size-1] = null;
        size--;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() { return new QueueIterator(); }

    @Override
    public T peek() {
        return null;
    }

    private class QueueIterator implements Iterator<T>
    {
        private int i = 0;
        public boolean hasNext() { return i < size; }
        public void remove() { /* not supported */ }
        public T next() { return underlyingArr[i++]; }
    }
}
