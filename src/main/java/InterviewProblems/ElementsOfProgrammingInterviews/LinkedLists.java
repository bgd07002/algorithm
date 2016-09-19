package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.ListStackQueue.Node;
import DataStructures.ListStackQueue.SinglyLinkedList;

public class LinkedLists<T extends Comparable<T>>{

    /**
     * 7.3 Median of Sorted Circular Linked List
     */
    public T medianSortedCircularList(SinglyLinkedList<T> list) {
        Node<T> cur = list.getHead();
        while (cur.getNext().getValue().compareTo(cur.getValue()) >= 0) {
            cur = cur.getNext();
        }

        cur = cur.getNext();
        Node<T> fasterCur = cur;

        while (fasterCur.getValue().compareTo(cur.getValue()) >= 0) {
            cur = cur.getNext();
            fasterCur = fasterCur.getNext();
            fasterCur = fasterCur.getNext();
        }
        return cur.getValue();
    }

    /**
     * 7.9 Reversing a Singly Linked List
     */
    public SinglyLinkedList<T> reverseSinglyLinkedList(SinglyLinkedList<T> list) {

        Node<T> cur = list.getHead();
        Node<T> reverseNext = null;
        Node<T> next = null;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(reverseNext);
            reverseNext = cur;
            cur = next;
        }

        list.setHead(reverseNext);
        return list;
    }
}
