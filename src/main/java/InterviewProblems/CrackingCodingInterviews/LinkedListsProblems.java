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

        if (list.size() < 2)
            return;

        DoublyLLNode<T>  cur1 = (DoublyLLNode<T>) list.getHead();

        while (cur1 != null) {

            DoublyLLNode<T> cur2 = cur1.getPrev();
            while(cur2 != null) {
                if (cur2.getValue().equals(cur1.getValue())) {
                    list.remove(cur2.getValue());
                }
                cur2 = cur2.getPrev();
            }
            cur1 = (DoublyLLNode<T>) cur1.getNext();
        }
    }

    /**
     * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
     */
    public T kThLastElement(SinglyLinkedList<T> list, int k) {
        if (list.size() < k)
            return null;

        Node<T>  cur1 = list.getHead();
        for (int i =0; i < k; i++)
            cur1 = cur1.getNext();

        Node<T> cur2 = list.getHead();
        while (cur1 != null) {
            cur1 = cur1.getNext();
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

        if (list.size() < 1)
            return;

        Node<T> cur1 = list.getHead();
        Node<T> cur2 = list.getHead();

        while (cur2.getNext() != null) {
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
        LinkedList<Integer> aList = new LinkedList<>();
        LinkedList<Integer> bList = new LinkedList<>();

        while (a > 0) {
            aList.add(a%10);
            a /= 10;
        }

        while(b > 0)
        {
            bList.add(b%10);
            b /= 10;
        }

        LinkedList<Integer> sumList = new LinkedList<>();
        int residue = 0;
        int i;

        for (i =0; i < aList.size() && i < bList.size(); i++) {
            int addedDigit = aList.get(i) + bList.get(i) + residue;
            residue = addDigitToSum(addedDigit, sumList);
        }

        while (bList.size()-i > 0) {
            int addedDigit = bList.get(i++) + residue;
            residue = addDigitToSum(addedDigit, sumList);
        }

        while (aList.size()-i > 0) {
            int addedDigit = aList.get(i) + residue;
            residue = addDigitToSum(addedDigit, sumList);
        }

        if (residue > 0)
            sumList.add(residue);

        int sum = 0;
        for (int j = 0; j < sumList.size(); j++ ) {
            sum += sumList.get(j) * Math.pow(10, j);
        }
        return sum;
    }

    private int addDigitToSum(int addedDigit, LinkedList<Integer> sum) {
        int residue = 0;
        if (addedDigit > 9)
            residue = addedDigit/10;
        sum.add(addedDigit % 10);
        return residue;
    }

    /**
     * 2.6 Implement a function to check if a linked list is a palindrome.
     * If SinglyLinkedList: Find the middle node, then convert pointers of second
     * half of lists, then compare.
     */
    public boolean isListPalindrome(DoublyLinkedList<T> list) {
        if (list.isEmpty())
            return true;

        DoublyLLNode<T> cur1 = (DoublyLLNode)list.getHead();
        DoublyLLNode<T> cur2 = (DoublyLLNode)list.getTail();

        int i =0;
        while (i <= list.size()/2) {
            if(cur1.getValue() != cur2.getValue())
                return false;

            i++;
            cur1 = (DoublyLLNode) cur1.getNext();
            cur2 = (DoublyLLNode) cur2.getPrev();
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

        while(cur1 != null){
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
     * 2.8 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
     * DEFINITION
     * Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
     * EXAMPLE
     * input: A -> B -> C -> D -> E -> C [the same C as earlier]
     * output: C
     */

}
