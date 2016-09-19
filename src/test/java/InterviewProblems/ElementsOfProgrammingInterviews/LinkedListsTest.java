package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.ListStackQueue.Node;
import DataStructures.ListStackQueue.SinglyLinkedList;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LinkedListsTest {

    @Test
    public void medianSortedCircularListTest() {
        /**
         *     Head-|
         *          |
         *    6 -> 17 -> 2 -> 2 -> 3 ->|
         *    ^                        |
         *    | <- <- <- <- <- <- <- <-|
         */
        LinkedLists l = new LinkedLists();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(17);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        Node<Integer> cur = list.getHead().getNext().getNext().getNext();
        Node<Integer> node = new Node<>(6, null);
        node.setNext(list.getHead());
        cur.setNext(node);
        Assert.assertEquals(6, l.medianSortedCircularList(list));
    }

    @Test
    public void reverseSinglyLinkedListTest() {
        LinkedLists l = new LinkedLists();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list = l.reverseSinglyLinkedList(list);
        Node<Integer> cur = list.getHead();
        Assert.assertEquals(7, (int)cur.getValue());
        Assert.assertEquals(6, (int)cur.getNext().getValue());
        Assert.assertEquals(4, (int)cur.getNext().getNext().getNext().getValue());
    }
}
