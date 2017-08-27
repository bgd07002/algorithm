package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.ListStackQueue.Node;
import DataStructures.ListStackQueue.SinglyLinkedList;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LinkedListsTest {

    @Test
    public void mergeSortedLists() {
        SinglyLinkedList<Integer> first = new SinglyLinkedList<>();
        first.addLast(2);
        first.addLast(4);
        first.addLast(6);
        first.addLast(8);
        SinglyLinkedList<Integer> second = new SinglyLinkedList<>();
        second.addLast(1);
        second.addLast(3);
        second.addLast(5);
        second.addLast(7);
        second.addLast(9);
        LinkedLists l = new LinkedLists();
        l.mergeSortedLists(first, second);

        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", first.printElements());
        first = new SinglyLinkedList<>();
        first.addLast(2);
        first.addLast(4);
        first.addLast(6);
        first.addLast(8);
        second = new SinglyLinkedList<>();
        second.addLast(1);
        second.addLast(3);

        l.mergeSortedLists(first, second);
        Assert.assertEquals("[1, 2, 3, 4, 6, 8]", first.printElements());
    }

    @Test
    public void isListCircularTest() {
        LinkedLists l = new LinkedLists();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(2);
        list.addLast(4);
        list.addLast(6);
        list.addLast(8);
        list.addLast(1);
        list.addLast(3);
        list.addLast(5);
        Assert.assertEquals(false, l.isListCircular(list));
        list.addLast(7);
        Assert.assertEquals(false, l.isListCircular(list));
        Node<Integer> tail = list.getHead().getNext().getNext().getNext().getNext().getNext().getNext().getNext();
        tail.setNext(list.getHead());

        Assert.assertEquals(true, l.isListCircular(list));
    }

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
        l.reverseSinglyLinkedList(list);
        Node<Integer> cur = list.getHead();
        Assert.assertEquals(7, (int)cur.getValue());
        Assert.assertEquals(6, (int)cur.getNext().getValue());
        Assert.assertEquals(4, (int)cur.getNext().getNext().getNext().getValue());
    }
}
