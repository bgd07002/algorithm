package DataStructures.ListStackQueue;


public class SinglyLinkedList<T extends Comparable<T>> extends IList<T>{

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T element) {
        if (size ==0)
            head = new Node<>(element, null);
        else {
            Node<T> newNode = new Node<>(element, head);
            head = newNode;
        }
        size++;
    }

    public void addLast(T element) {
        if (size == 0)
            head = new Node<>(element, head);
        else {
            Node<T> cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(new Node(element, null));
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0)
            return null;

        if (size == 1) {
            Node<T> cur = head;
            head = null;
            size--;
            return cur.getValue();
        }

        Node<T> cur = head;
        head = head.getNext();
        size--;
        return cur.getValue();
    }

    public T removeLast() {
        if (size == 0)
            return null;

        if (size == 1) {
            Node<T> cur = head;
            head = null;
            size--;
            return cur.getValue();
        } else {
            Node<T> cur1 = head;
            Node<T> cur2 = cur1.getNext();

            while (cur2.getNext() != null) {
                cur1 = cur1.getNext();
                cur2 = cur2.getNext();
            }
            cur1.setNext(null);
            size--;
            return cur2.getValue();
        }
    }

    public void remove(T objValue) {
        if (size == 0)
            return;

        if (head.getValue().equals(objValue)) {
            removeFirst();
            return;
        }

        Node<T> cur1 = head;
        Node<T> cur2 = cur1.getNext();

        while(cur2 != null) {
            if (cur2.getValue().equals(objValue)) {
                cur1.setNext(cur2.getNext());
                size--;
                break;
            }
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }
    }

    public int size() { return size; }
    public void setSize(int size) {
        this.size = size;
    }
    public Node<T> getHead() { return head; }
    public void setHead(Node<T> head) {
        this.head = head;
    }
}
