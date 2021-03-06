package DataStructures.ListStackQueue;

public class DoublyLinkedList<T extends Comparable<T>> extends IList<T>  {

    private DoublyLLNode<T> head;
    private DoublyLLNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size =0;
    }

    public void addFirst(T element) {
        if (size == 0) {
            head = tail = new DoublyLLNode<>(null, null, element);
        } else {
            DoublyLLNode<T> cur = new DoublyLLNode<>(head, null, element);
            head.setPrev(cur);
            head = cur;
        }
        size++;
    }

    public void addLast(T element) {
        if (size == 0) {
            head = tail = new DoublyLLNode<>(null, null, element);
        } else {
            DoublyLLNode<T> cur = new DoublyLLNode<>(null, tail, element);
            tail.setNext(cur);
            tail = cur;
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0)
            return null;

        DoublyLLNode<T> cur = head;
        head = (DoublyLLNode<T>) head.getNext();
        size--;
        return cur.getValue();
    }

    public T removeLast() {
        if (size == 0)
            return null;

        DoublyLLNode<T> cur = tail;
        tail = tail.getPrev();
        size--;
        return cur.getValue();
    }

    public void remove(T objValue) {
        if (size == 0)
            return;

        DoublyLLNode<T> cur = head;
        while (cur != null) {
            if (cur.getValue().equals(objValue)) {
                if (cur.equals(head)) {
                    removeFirst();
                } else {
                    cur.getPrev().setNext(cur.getNext());
                    size--;
                }
                break;
            }
            cur = (DoublyLLNode<T>) cur.getNext();
        }
    }

    public int size() {
        return size;
    }
    public DoublyLLNode<T> getHead() {
        return head;
    }
    public DoublyLLNode<T> getTail() {
        return tail;
    }



















    /*
    private DoublyLLNode<T> head;
    private DoublyLLNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public void addFirst(T element) {
        if (isEmpty())
            head = tail = new DoublyLLNode<>(null, null, element);
        else {
            DoublyLLNode<T> temp = head;
            DoublyLLNode<T> newNode = new DoublyLLNode<>(temp, null, element);
            temp.setPrev(newNode);
            head= newNode;
        }
        size++;
    }

    public void addLast(T element) {
        if (isEmpty())
            head = tail = new DoublyLLNode<>(null, null, element);
        else {
            DoublyLLNode<T> newNode = new DoublyLLNode<>(null, tail, element);
            DoublyLLNode<T> temp = tail;
            temp.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        //This means either list has no content or have only one content
        if (head == tail) {
            if (head == null)
                return null;
            T temp = head.getValue();
            head = tail = null;
            size--;
            return temp;
        }

        DoublyLLNode<T> removedNode = head;
        head = (DoublyLLNode<T>) head.getNext();
        head.setPrev(null);
        size--;
        return removedNode.getValue();
    }

    public T removeLast() {
        //This means either list has no content or have only one content
        if (head == tail) {
            if (head == null)
                return null;
            T temp = head.getValue();
            size--;
            head = tail = null;
            return temp;
        }

        DoublyLLNode<T> removedNode = tail;
        tail = removedNode.getPrev();
        tail.setNext(null);
        size--;
        return removedNode.getValue();
    }

    public void remove(T objValue) {

        if (head == null)
            return;

        if (head.getValue().equals(objValue))
            removeFirst();

        if (tail.getValue().equals(objValue))
            removeLast();

        DoublyLLNode<T> cur = head;
        while (cur != null) {
            if (cur.getValue().equals(objValue)) {
                DoublyLLNode<T> next = (DoublyLLNode<T>) cur.getNext();
                next.setPrev(cur.getPrev());
                cur.getPrev().setNext(next);
                size--;
                break;
            }
            cur = (DoublyLLNode<T>) cur.getNext();
        }
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
    */
}
