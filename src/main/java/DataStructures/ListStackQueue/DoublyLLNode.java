package DataStructures.ListStackQueue;

public class DoublyLLNode<T> extends Node<T>{

    private DoublyLLNode prev;

    public DoublyLLNode(DoublyLLNode next, DoublyLLNode prev, T value) {
        super(value, next);
        this.prev = prev;
    }

    public DoublyLLNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLLNode prev) {
        this.prev = prev;
    }
}
