package DataStructures.ListStackQueue;

public class Node<T> {
    private Node next;
    private T value;

    public Node(T value, Node next) {
        this.next = next;
        this.value= value;
    }

    public Node getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
