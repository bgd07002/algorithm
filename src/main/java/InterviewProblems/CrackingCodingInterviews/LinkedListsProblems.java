package InterviewProblems.CrackingCodingInterviews;


import DataStructures.ListStackQueue.DoublyLLNode;
import DataStructures.ListStackQueue.Node;
import DataStructures.ListStackQueue.DoublyLinkedList;
import DataStructures.ListStackQueue.SinglyLinkedList;

import java.util.LinkedList;

public class LinkedListsProblems<T extends Comparable<T>> {

    /**
     * 2.1 Write code to remove duplicates from an unsorted linked list.
     * Solution 2: If additional data structure allowed, create HashMap and add integers.
     * Solution 3: Or sort the linked list and remove the duplicates.
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    public void removeDuplicates(DoublyLinkedList<T> list) {

        if (list.size() <= 1)
            return;

        DoublyLLNode<T> cur = list.getHead();

        while(cur != null) {
            DoublyLLNode<T> cur2 = (DoublyLLNode<T>) cur.getNext();

            while(cur2 != null) {
                if (cur.equals(cur2)) {
                    DoublyLLNode<T> temp = cur2;
                    cur2 = (DoublyLLNode<T>) cur2.getNext();
                    list.remove(temp.getValue());
                } else {
                    cur2 = (DoublyLLNode<T>) cur2.getNext();
                }
            }
            cur = (DoublyLLNode<T>) cur.getNext();
        }
    }

    /**
     * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
     */
    public T kThLastElement(SinglyLinkedList<T> list, int k) {

        if (list.size() < k)
            return null;

        Node<T> cur = list.getHead();
        for (int i=0; i < k; i++){
            cur = cur.getNext();
        }

        Node<T> cur2 = list.getHead();
        while (cur != null) {
            cur = cur.getNext();
            cur2 = cur2.getNext();
        }

        return cur2.getValue();
    }

    /**
     * 2.3 Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
     * EXAMPLE
     * Input: the node ‘c’ from the linked list a->b->c->d->e
     * Result: nothing is returned, but the new linked list looks like a->b->d->e
     */
    public void removeMiddleNode(SinglyLinkedList<T> list) {

        if (list.size() <= 1) {
            if (list.size() == 1)
                list.removeFirst();
            return;
        }

        Node<T> cur1 = list.getHead();
        Node<T> cur2 = cur1;

        while(cur2 != null && cur2.getNext() != null) {
            cur1 = cur1.getNext();
            cur2 = cur2.getNext();
            if (cur2 == null)
                break;

            cur2 = cur2.getNext();
        }

        list.remove(cur1.getValue());
    }

    /**
     * 2.5 You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
     * Write a function that adds the two numbers and returns the sum as a linked list.
     * EXAMPLE
     * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
     * Output: 8 -> 0 -> 8
     */
    public int sumList(int a, int b) {

        LinkedList<Integer> aList = numberToList(a);
        LinkedList<Integer> bList = numberToList(b);

        LinkedList<Integer> sumList = new LinkedList<>();

        int carryOver = 0;
        int i = 0;
        for(; i < aList.size() && i < bList.size(); i++) {
            sumList.add((aList.get(i) + bList.get(i) + carryOver)%10);
            carryOver = (aList.get(i) + bList.get(i) + carryOver) / 10;
        }

        while (i < aList.size()) {
            sumList.add((aList.get(i) + carryOver)%10);
            carryOver = (aList.get(i++) + carryOver) / 10;
        }

        while (i < bList.size()) {
            sumList.add((bList.get(i) + carryOver)%10);
            carryOver = (bList.get(i++) + carryOver) / 10;
        }

        if (carryOver > 0)
            sumList.add(carryOver);

        int sum =0;
        for (int j=sumList.size()-1; j >=0; j--) {
            sum = 10*sum + sumList.get(j);
        }
        return sum;
    }

    private LinkedList<Integer> numberToList(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        return list;
    }

    /**
     * 2.6 Implement a function to check if a linked list is a palindrome.
     * If SinglyLinkedList: Find the middle node, then convert pointers of second
     * half of lists, then compare.
     * Or put the second half into a stack and compare with first half one by one.
     */
    public boolean isListPalindrome(DoublyLinkedList<T> list) {
        if (list.size() < 2)
            return true;

        DoublyLLNode<T> cur1 = list.getHead();
        DoublyLLNode<T> cur2 = list.getTail();

        int i =0;
        while (i < list.size()/2) {
            if (!cur1.getValue().equals(cur2.getValue()))
                return false;
            else {
                cur1 = (DoublyLLNode<T>) cur1.getNext();
                cur2 = (DoublyLLNode<T>) cur2.getPrev();
            }
            i++;
        }
        return true;
    }

    /**
     * 2.7 Intersection: Given two (singly) linked lists, determine if the two list intersects.
     * Return intersecting node.
     */
    public Node<T> findIntersectingNode(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {

        if (list1.isEmpty() || list2.isEmpty())
            return null;

        Node<T> cur1 = list1.getHead();
        while (cur1 != null) {
            Node<T> cur2 = list2.getHead();
            while (cur2 != null) {
                if (cur1 == cur2)
                    return cur1;
                cur2 = cur2.getNext();
            }
            cur1 = cur1.getNext();
        }
        return null;
    }

    /**
     * 2.8 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
     * (Elements of Coding Interview 8.3)
     */

}
