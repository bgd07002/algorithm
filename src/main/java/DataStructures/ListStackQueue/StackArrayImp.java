package DataStructures.ListStackQueue;

import java.util.Iterator;

public class StackArrayImp<T> implements IStack<T>, Iterable<T> {

    private T[] underlyingArr;
    private int size;
    private static final int DEFAULTSIZE = 10;

    public StackArrayImp() {
        this(DEFAULTSIZE);
    }

    public StackArrayImp(int initialSize) {
        underlyingArr = (T[]) new Object[initialSize];
    }

    public void push(T element) {
        if (size >=  underlyingArr.length) {
            T[] expandedArr = (T[]) new Object[size * 2];
            System.arraycopy(underlyingArr, 0, expandedArr, 0, size);
            underlyingArr = expandedArr;
        }

        underlyingArr[size++] = element;
    }

    public T pop() {
        if (size == 0)
            return null;

        return underlyingArr[--size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<T> iterator() { return new StackIterator(); }

    private class StackIterator implements Iterator<T>
    {
        private int i = size;
        public boolean hasNext() { return i > 0; }
        public void remove() { /* not supported */ }
        public T next() { return underlyingArr[--i]; }
    }
}
