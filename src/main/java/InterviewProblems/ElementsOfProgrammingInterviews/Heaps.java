package InterviewProblems.ElementsOfProgrammingInterviews;


import DataStructures.HeapPriorityQueue.ArrayHeap;
import DataStructures.HeapPriorityQueue.Entry;
import DataStructures.HeapPriorityQueue.IHeap;

import java.util.*;

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
     * Brute force approach O(NlogN)
     * Strategy: Reverse the decreasing order and then merge the result. Merging cost O(N)
     */
    public int[] sortIncreasingDecreasingArray(int[] arr) {
        if (arr.length < 2)
            return arr;

        int decreasingIdx = 0;
        int reIncreasingIdx = 0;

        for (int i=1; i< arr.length; i++) {
            if (decreasingIdx == 0 && arr[i] < arr[i-1])
                decreasingIdx = i;

            if (reIncreasingIdx == 0 && decreasingIdx > 0 && arr[i] > arr[i-1]) {
                reIncreasingIdx = i;
                reverseDecreasing(arr, decreasingIdx, reIncreasingIdx);
                decreasingIdx =0;
                reIncreasingIdx =0;
            }
        }

        if (decreasingIdx > 0)
            reverseDecreasing(arr, decreasingIdx, arr.length);

        //Iteratively merge sub arrays
        int endOfFirstSubArr = 0;
        int endSecondSubArray = 0;
        for (int i=1; i< arr.length; i++) {
            if (endOfFirstSubArr ==0 && arr[i] < arr[i-1]) {
                endOfFirstSubArr = i;
                continue;
            }

            if (endOfFirstSubArr > 0 && arr[i] < arr[i-1]) {
                endSecondSubArray = i;
                mergeSortedSubArrays(arr, endOfFirstSubArr, endSecondSubArray);
                endOfFirstSubArr = endSecondSubArray;
                endSecondSubArray=0;
            }
        }

        if (endOfFirstSubArr > 0)
            mergeSortedSubArrays(arr, endOfFirstSubArr, arr.length);
        return arr;
    }

    private void mergeSortedSubArrays(int[] arr, int endOfFirstSubArr, int endSecondSubArray) {
        int[] auxArr = new int[endSecondSubArray];

        //Merge operation
        int cur1=0, cur2=endOfFirstSubArr;
        int auxIdx=0;
        while (cur1 < endOfFirstSubArr && cur2 < endSecondSubArray) {
            auxArr[auxIdx] = (arr[cur1] >= arr[cur2])? arr[cur2++]: arr[cur1++];
            auxIdx++;
        }

        //Try to eliminate these for optimization purposes
        if (cur1 < endOfFirstSubArr)
            System.arraycopy(arr, cur1, auxArr, auxIdx, endOfFirstSubArr-cur1);

        if (cur2 < endSecondSubArray)
            System.arraycopy(arr, cur2, auxArr, auxIdx, endSecondSubArray-cur2);

        //Copy the sorted and merged items into original array
        System.arraycopy(auxArr,0, arr,0,endSecondSubArray);
    }

    private void reverseDecreasing(int[] arr, int decreasingIdx, int reIncreasingIdx) {
        int cur = 0;
        while (reIncreasingIdx-1-cur > decreasingIdx+cur) {
            int temp = arr[decreasingIdx+cur];
            arr[decreasingIdx+cur] = arr[reIncreasingIdx-1-cur];
            arr[reIncreasingIdx-1-cur] = temp;
            cur++;
        }
    }


}
