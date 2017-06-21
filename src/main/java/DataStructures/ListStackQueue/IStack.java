package DataStructures.ListStackQueue;

import java.util.Iterator;

public interface IStack<T> {
    void push(T element);
    T pop();
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
}
