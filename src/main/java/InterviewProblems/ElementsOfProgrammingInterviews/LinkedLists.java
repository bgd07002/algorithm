package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.ListStackQueue.Node;
import DataStructures.ListStackQueue.SinglyLinkedList;

public class LinkedLists<T extends Comparable<T>>{

    /**
     * 8.1 Merge Two Sorted Singly Lists
     */
    public void mergeSortedLists(SinglyLinkedList<T> first, SinglyLinkedList<T> second) {

        Node<T> cur1 = first.getHead();
        Node<T> cur2 = second.getHead();

        if (cur1 == null) {
            first = second;
            return;
        }

        Node<T> cur1Next = (cur1.getNext() != null) ? cur1.getNext() : null;

        if (cur1.getValue().compareTo(cur2.getValue()) > 0) {
            Node<T> temp = cur2;
            cur2 = cur2.getNext();
            first.setHead(temp);
            temp.setNext(cur1);
            first.setSize(first.size()+1);
        }


        while (cur1Next != null && cur2 != null) {
            int comp = cur1Next.getValue().compareTo(cur2.getValue());

            if (comp <= 0) {
                cur1 = cur1.getNext();
                cur1Next = cur1Next.getNext();
            }
            else {
                Node<T> temp = cur2;
                cur2 = cur2.getNext();
                cur1.setNext(temp);
                temp.setNext(cur1Next);
                cur1 = temp;
                first.setSize(first.size()+1);
            }
        }

        while (cur2 != null) {
            Node<T> temp = cur2;
            cur1.setNext(temp);
            cur2 = cur2.getNext();
            first.setSize(first.size()+1);
        }
    }

    /**
     * 8.2 Reversing a Singly Linked List
     */
    public void reverseSinglyLinkedList(SinglyLinkedList<T> list) {

        if (list.size() < 2)
            return;

        //1--> 2 --> 3 --> 4
        //1<-- 2 --> 3 --> 4
        Node<T> cur = list.getHead();
        Node<T> reverseNext = null;
        Node<T> next;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(reverseNext);
            reverseNext = cur;
            cur = next;
        }
        list.setHead(reverseNext);
    }

    /**
     * 8.3 Checking for Cyclicity: Given a reference to the head of linked list L. How would you
     * determine whether L ends with null or cycle.
     */
    public T findHeadOfCircularList(SinglyLinkedList<T> list) {
        if (list.size() < 2)
            return null;

        Node<T> cur1 = list.getHead().getNext();
        Node<T> cur2 = list.getHead().getNext().getNext();

        int cycleLength = 1;
        while (cur2 != null && cur2.getNext() != null) {
            if (cur1.getValue().equals(cur2.getValue()))
                break;

            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
            cur2 = cur2.getNext();
            cycleLength++;
        }

        if (cur2 == null || cur2.getNext() == null)
            return null;

        //After we found the cycle length. We start traversing with two cursor again.
        //First one is cycleLength after the second one.
        cur2 = list.getHead();
        for (int i =0; i< cycleLength; i++)
            cur2 = cur2.getNext();

        cur1 = list.getHead();
        while (!cur1.getValue().equals(cur2.getValue())){
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
        }
        return cur1.getValue();
    }

    /**
     * 8.4 Test for overlapping two singly linked lists. Lists are cycle free (Cracking Coding Interview 2.7)
     * 8.6 Delete a node from Singly Linked Lists (Implemented in DataStructures/SinglyLinkedLists)
     * 8.7 Remove the kth last element from singly linked list
     */

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
     *
     */

    /**
     * 8.11 Test singly linked list is palindrome (Cracking coding interview 2.6)
     */

    /**
     * 8.13 Add list based integers (Cracking coding interview 2.5)
     */
}
