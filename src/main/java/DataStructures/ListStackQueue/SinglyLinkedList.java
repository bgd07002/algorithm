package DataStructures.ListStackQueue;


public class SinglyLinkedList<T extends Comparable<T>> extends IList<T>{

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T element) {
        if (size == 0) {
            head = new Node<T>(element, null);
        } else {
            head = new Node(element, head);
        }
        size++;
    }
    public void addLast(T element) {
        if (size == 0) {
            head = new Node<T>(element, null);
        } else {
            Node<T> cur = head;

            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            Node<T> newNode = new Node(element, null);
            cur.setNext(newNode);
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0)
            return null;

        T temp = head.getValue();
        head = head.getNext();
        size--;
        return temp;
    }

    public T removeLast() {
        if (size == 0)
            return null;

        T returnedVal;
        if (size == 1) {
            returnedVal = head.getValue();
            head = null;
        } else {
            Node<T> cur1 = head;
            Node<T> cur2 = head.getNext();

            while (cur2.getNext() != null) {
                cur1 = cur1.getNext();
                cur2 = cur2.getNext();
            }
            returnedVal = cur2.getValue();
            cur1.setNext(null);
        }
        size--;
        return returnedVal;
    }

    public void remove(T objValue) {
        if (size == 0)
            return;

        if (head.getValue() == objValue) {
            removeFirst();
        } else if (size > 1){
            Node<T> cur1 = head;
            Node<T> cur2 = head.getNext();

            while (cur2.getNext() != null) {
                if (cur2.getValue().equals(objValue)) {
                    cur1.setNext(cur2.getNext());
                    size--;
                    break;
                }

                cur1 = cur1.getNext();
                cur2 = cur2.getNext();
            }
        }
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
