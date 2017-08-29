package InterviewProblems.ElementsOfProgrammingInterviews;


import DataStructures.HeapPriorityQueue.ArrayHeap;
import DataStructures.HeapPriorityQueue.Entry;
import DataStructures.HeapPriorityQueue.IHeap;

import java.util.ArrayList;
import java.util.List;

public class Heaps {

    /**
     * 11.1 Merge the list of sorted arrays into a single sorted list
     */
    public List<Integer> mergeSortedArrays(List<int[]> sortedArrLists) {

        List<Integer> mergedList = new ArrayList<>();
        IHeap<Integer, Integer> heap = new ArrayHeap<>();
        for (int[] arr : sortedArrLists) {
            for (int i : arr)
                heap.insert(new Entry<>(i, 0));
        }

        while (heap.getSize() > 0)
            mergedList.add(heap.extractMin().getKey());

        return mergedList;
    }

    /**
     * 11.2 Sort Increasing Decreasing Array
     */
    public List<Integer> sortIncreasingDecreasingArray(int[] arr) {

        return null;
    }
}
