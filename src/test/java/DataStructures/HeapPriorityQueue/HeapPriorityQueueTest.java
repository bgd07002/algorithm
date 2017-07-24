package DataStructures.HeapPriorityQueue;

import org.junit.Assert;
import org.testng.annotations.Test;

public class HeapPriorityQueueTest {

    //        5
    //  14,       7
    //30, 50   10, 20
    @Test
    public void priorityQueueTest() {
        IHeap<Integer, String> heap = new ArrayHeap<>();
        heap.insert(new Entry<>(5, "Bes"));
        heap.insert(new Entry<>(14,"On dort"));
        heap.insert(new Entry<>(7, "Yedi"));
        heap.insert(new Entry<>(30, "Otuz"));
        heap.insert(new Entry<>(50, "Elli"));
        heap.insert(new Entry<>(10, "On"));
        heap.insert(new Entry<>(20, "Yirmi"));
        heap.insert(new Entry<>(35, "Otuz Bes"));
        heap.insert(new Entry<>(36, "Otuzalti"));
        heap.insert(new Entry<>(60, "Altmis"));
        heap.insert(new Entry<>(70, "Yetmis"));
        Assert.assertEquals("5, 14, 7, 30, 50, 10, 20, 35, 36, 60, 70, ", heap.printHeap());
        heap.insert(new Entry<>(1, "Bir"));
        Assert.assertEquals("1, 14, 5, 30, 50, 7, 20, 35, 36, 60, 70, 10, ", heap.printHeap());
        Assert.assertEquals(12, heap.getSize());

        Assert.assertEquals("Bir", heap.extractMin().getValue());
        Assert.assertEquals("5, 14, 7, 30, 50, 10, 20, 35, 36, 60, 70, ", heap.printHeap());

        Assert.assertEquals("Bes", heap.extractMin().getValue());
        Assert.assertEquals("7, 14, 10, 30, 50, 70, 20, 35, 36, 60, ", heap.printHeap());

        Assert.assertEquals("Yedi", heap.extractMin().getValue());
        Assert.assertEquals("10, 14, 20, 30, 50, 70, 60, 35, 36, ", heap.printHeap());

        Assert.assertEquals("On", heap.extractMin().getValue());
        Assert.assertEquals("14, 30, 20, 35, 50, 70, 60, 36, ", heap.printHeap());

        Assert.assertEquals("On dort", heap.extractMin().getValue());
        Assert.assertEquals("20, 30, 36, 35, 50, 70, 60, ", heap.printHeap());

        Assert.assertEquals(7, heap.getSize());
    }
}
