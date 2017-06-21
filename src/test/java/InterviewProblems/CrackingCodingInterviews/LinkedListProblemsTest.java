package InterviewProblems.CrackingCodingInterviews;

import DataStructures.ListStackQueue.DoublyLinkedList;
import DataStructures.ListStackQueue.Node;
import DataStructures.ListStackQueue.SinglyLinkedList;
import InterviewProblems.CrackingCodingInterviews.LinkedListsProblems;
import org.junit.Assert;
import org.testng.annotations.Test;

public class LinkedListProblemsTest {

    @Test
    public void removeDuplicatesTest() {
        DoublyLinkedList<String> str = new DoublyLinkedList<>();
        str.addLast("F");
        str.addLast("O");
        str.addLast("L");
        str.addLast("L");
        str.addLast("O");
        str.addLast("W");
        str.addLast(" ");
        str.addLast("U");
        str.addLast("P");

        LinkedListsProblems<String> llP = new LinkedListsProblems<>();
        llP.removeDuplicates(str);
        str.printElements();
        Assert.assertEquals(7, str.size());

        Assert.assertEquals("F", str.getHead().getValue());
        Assert.assertEquals("W", str.getHead().getNext().getNext().getNext().getValue());
    }

    @Test
    public void kThLastElementTest() {
        SinglyLinkedList<Integer> sa = new SinglyLinkedList<>();
        sa.addLast(3);
        sa.addLast(4);
        sa.addLast(5);
        sa.addLast(1);
        sa.addLast(2);
        sa.addLast(6);
        //3,4,5,1,2,6
        sa.printElements();

        LinkedListsProblems lt = new LinkedListsProblems();
        Assert.assertEquals(1, lt.kThLastElement(sa, 3));
        Assert.assertEquals(null, lt.kThLastElement(sa, 7));
    }

    @Test
    public void removeMiddleElementTest() {
        SinglyLinkedList<String> sa = new SinglyLinkedList<>();
        sa.addLast("a");

        LinkedListsProblems llP = new LinkedListsProblems();
        llP.removeMiddleNode(sa);
        Assert.assertEquals(sa.size(), 0);
        sa.addLast("a");
        sa.addLast("b");
        sa.addLast("c");
        sa.addLast("d");
        sa.addLast("e");

        llP.removeMiddleNode(sa);
        sa.printElements();
        Assert.assertEquals(sa.size(), 4);
    }

    @Test
    public void sumListTest() {
        LinkedListsProblems<Integer> llP = new LinkedListsProblems<>();
        int sum = llP.sumList(513, 295);
        Assert.assertEquals(808, sum);

        sum = llP.sumList(24, 987);
        Assert.assertEquals(1011, sum);
    }

    @Test
    public void palindromeTest() {
        LinkedListsProblems<Integer> llP = new LinkedListsProblems<>();
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        Assert.assertEquals(true, llP.isListPalindrome(list));

        list.remove(4);
        Assert.assertEquals(true, llP.isListPalindrome(list));

        list.addLast(7);
        Assert.assertEquals(false, llP.isListPalindrome(list));
    }

    @Test
    public void intersectionTest() {
        LinkedListsProblems<Integer> llP = new LinkedListsProblems<>();
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        Node<Integer> intersect = list1.getHead().getNext().getNext();

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.addLast(10);
        list2.addLast(9);
        list2.addLast(8);
        list2.addLast(7);
        list2.addLast(6);
        Node<Integer> connect = list2.getHead().getNext().getNext().getNext().getNext();
        connect.setNext(intersect);

        Node<Integer> commonNode = llP.findIntersectingNode(list1, list2);
        Assert.assertEquals(3, (int)commonNode.getValue());

        //List 2: 10 -> 9 -> 8 -> 7 -> 6 -> 3 -> 4 -> 5
        //List 1:                 1 -> 2 -> 3 -> 4 -> 5
    }
}
