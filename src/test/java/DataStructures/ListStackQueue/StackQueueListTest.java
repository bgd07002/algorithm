package DataStructures.ListStackQueue;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;

public class StackQueueListTest {

    @Test
    public void stackPushandPopArrayImp() throws Exception {
        IStack<Integer> sa = new StackArrayImp<Integer>(3);
        Assert.assertTrue(sa.isEmpty());
        sa.push(3);
        sa.push(4);
        int poppedEl = sa.pop();
        Assert.assertTrue(poppedEl == 4);
        Assert.assertTrue(sa.size()== 1);
        poppedEl = sa.pop();
        Assert.assertTrue(poppedEl == 3);
        Assert.assertTrue(sa.pop() == null);

        sa.push(1);
        sa.push(2);
        sa.push(3);
        sa.push(4);
        poppedEl = sa.pop();
        Assert.assertTrue(poppedEl == 4);

        Iterator itr = sa.iterator();
        StringBuilder sb = new StringBuilder();
        while(itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        Assert.assertTrue(sb.toString().equals("3, 2, 1, "));
    }

    @Test
    public void stackPushandPopListImp() throws Exception {
        IStack<Integer> sa = new StackListImp<>();
        Assert.assertTrue(sa.isEmpty());
        sa.push(3);
        sa.push(4);
        int poppedEl = sa.pop();
        Assert.assertTrue(poppedEl == 4);
        Assert.assertTrue(sa.size()== 1);
        poppedEl = sa.pop();
        Assert.assertTrue(poppedEl == 3);
        Assert.assertTrue(sa.pop() == null);

        sa.push(1);
        sa.push(2);
        sa.push(3);
        sa.push(4);
        poppedEl = sa.pop();
        Assert.assertTrue(poppedEl == 4);

        Iterator itr = sa.iterator();
        StringBuilder sb = new StringBuilder();
        while(itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        Assert.assertTrue(sb.toString().equals("3, 2, 1, "));
    }

    @Test
    public void deQueueEnqueueListImpTest() throws Exception {
        IQueue<Integer> sa = new QueueListImp<Integer>();
        Assert.assertTrue(sa.isEmpty());
        sa.enqueue(3);
        sa.enqueue(4);
        int dequeuedEl = sa.dequeue();
        Assert.assertTrue(dequeuedEl == 3);
        Assert.assertTrue(sa.size()== 1);
        dequeuedEl = sa.dequeue();
        Assert.assertTrue(dequeuedEl == 4);
        Assert.assertTrue(sa.dequeue() == null);

        sa.enqueue(1);
        sa.enqueue(2);
        sa.enqueue(3);
        sa.enqueue(4);
        dequeuedEl = sa.dequeue();
        Assert.assertTrue(dequeuedEl == 1);

        Iterator itr = sa.iterator();
        StringBuilder sb = new StringBuilder();
        while(itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        Assert.assertTrue(sb.toString().equals("2, 3, 4, "));
    }

    @Test
    public void deQueueEnqueueArrImpTest() throws Exception {
        IQueue<Integer> sa = new QueueArrayImp<>(3);
        Assert.assertTrue(sa.isEmpty());
        sa.enqueue(3);
        sa.enqueue(4);
        int dequeuedEl = sa.dequeue();
        Assert.assertTrue(dequeuedEl == 3);
        Assert.assertTrue(sa.size()== 1);
        dequeuedEl = sa.dequeue();
        Assert.assertTrue(dequeuedEl == 4);
        Assert.assertTrue(sa.dequeue() == null);

        sa.enqueue(1);
        sa.enqueue(2);
        sa.enqueue(3);
        sa.enqueue(4);
        dequeuedEl = sa.dequeue();
        Assert.assertTrue(dequeuedEl == 1);

        Iterator itr = sa.iterator();
        StringBuilder sb = new StringBuilder();
        while(itr.hasNext()) {
            sb.append(itr.next()).append(", ");
        }
        Assert.assertTrue(sb.toString().equals("2, 3, 4, "));
    }

    private void listTestHelper(IList<Integer> sa) {
        Assert.assertTrue(sa.isEmpty());
        sa.addLast(3);
        sa.addFirst(4);
        sa.addLast(5);
        int el = sa.removeLast();
        Assert.assertTrue(el == 5);
        Assert.assertTrue(sa.size()== 2);
        el = sa.removeFirst();
        sa.removeFirst();
        Assert.assertTrue(el == 4);
        Assert.assertTrue(sa.removeFirst() == null);

        sa.addLast(1);
        sa.addLast(2);
        sa.addLast(3);
        sa.addLast(4);
        sa.printElements();
        sa.remove(3);
        Assert.assertTrue(sa.size() == 3);
        sa.remove(1);
        Assert.assertTrue(sa.size() == 2);
        sa.remove(4);
        Assert.assertTrue(sa.size() == 1);
    }

    @Test
    public void doublyListAddRemoveTest() throws Exception {
        IList<Integer> sa = new DoublyLinkedList<Integer>();
        listTestHelper(sa);
    }

    @Test
    public void singlyListAddRemoveTest() throws Exception {
        IList<Integer> sa = new SinglyLinkedList<Integer>();
        listTestHelper(sa);
    }
}
