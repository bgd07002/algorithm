package DataStructures.ListStackQueue;

public interface IStack<T> {
    void push(T element);
    T pop();
    int size();
    boolean isEmpty();
}
