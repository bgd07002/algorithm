package InterviewProblems.CrackingCodingInterview;

public class SortingAndSearching<T extends Comparable<T>> {

    /**
     * 10.1 Sorted Merge: Given two sorted arrays A and B where A has large enough buffer to hld B at the end.
     * Write method to merge B into A in sorted order.
     */
    public void sortedMerge(T[] A, T[] B) {

        if (B == null || B.length < 1)
            return;

        //First find number of elements in A
        int num = 0;
        while (A[num] != null) {
            num ++;
        }

        int i = 0, j = 0;
        while (j < B.length) {
            if (A[i].compareTo(B[j]) <= 0)
                i++;
            else {
                for (int k = num; k > i; k--)
                    A[k] = A[k-1];
                num++;
                A[i] = B[j];
                i++;
                j++;
            }
        }
    }

    /**
     * 10.2 Group Anagrams - Write a method to sort an array of strings so that anagrams are next to each other.
     */
    public void groupAnagrams(String[] strs) {

    }

    /**
     * 10.3 Search in Rotated Array: Given a sorted array of n integers that has been rotated in unknown
     * number of times. Write a code to find that element in the array.
     */
    public int searchInRotatedArray(int elem, int[] intArr) {
        return searchInRotatedArrayHelper(elem, intArr, 0, intArr.length-1);
    }

    private int searchInRotatedArrayHelper(int elem, int[] intArr, int start, int end) {

        int mid = (start+end)/2;
        if (elem == intArr[mid])
            return mid;

        if (mid > start) {
            if ((elem >= intArr[start] && elem < intArr[mid]) ||
                    (elem >= intArr[start] && elem > intArr[mid])) {

                return searchInRotatedArrayHelper(elem, intArr, start, mid);

            } else if ((elem > intArr[mid] && elem <= intArr[end]) ||
                    (elem < intArr[mid] && elem > intArr[mid])) {

                return searchInRotatedArrayHelper(elem, intArr, mid + 1, end);
            }
            else
                return -1;
        }
        else
            return -1;
    }

    /**
     * 10.4 Sorted Search, No Size: You are given an array-like structure Listy which lacks size method.
     * It does have an elementAt(i) method in O(1) time. If i is out of bounds, it returns -1 (data structure only
     * supports positive integers). Given Listy which contains sorted, positive integers, find the index at which
     * element x occurs. If x occurs multiple times, you may return any index.
     */
    public int findIdxSortedArray(int x, int[] intArr) {
        return -1;
    }

    /**
     * 10.9 Sorted Matrix Search: Given MxN matrix in which each row and each column is sorted in ascending
     * order, write a method to find an element.
     */
    public boolean sortedMatrixSearch(int element, int[][] sortedMatrix) {
        boolean isFound = false;
        for (int i=0; i < sortedMatrix.length; i++)
            isFound  = isFound || searchInRow(element, sortedMatrix[i], 0, sortedMatrix[i].length-1);

        return isFound;
    }

    private boolean searchInRow(int element, int[] arr, int start, int end) {
        int mid = (start+end)/2;

        if (element == arr[mid])
            return true;

        if(start<end) {
            if (element < arr[mid])
                return searchInRow(element, arr, start, mid-1);
            else
                return searchInRow(element, arr, mid+1, end);
        }
        return false;
    }
}
