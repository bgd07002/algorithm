package DataStructures.ListStackQueue;

public class Stack<T> implements IStack<T> {

    private T[] underlyingArray;
    private int top = -1;
    private final static int DEFAULT_ARR_SIZE = 10;

    public Stack() {
        this(DEFAULT_ARR_SIZE);
    }

    public Stack(int initialSize) {
        underlyingArray = (T[]) new Object[initialSize];
    }

    public void push(T element) {
        if (top == (underlyingArray.length-1)) {
            T[] tempArray = (T[]) new Object[underlyingArray.length * 2];
            System.arraycopy(underlyingArray, 0, tempArray, 0, underlyingArray.length);
            underlyingArray = tempArray;
        }

        underlyingArray[++top] = element;
    }

    public T pop() {
        if (isEmpty())
            return null;

        return underlyingArray[top--];
    }

    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
