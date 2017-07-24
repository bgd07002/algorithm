package InterviewProblems.CrackingCodingInterviews;

import java.util.Arrays;
import java.util.Comparator;

public class SortingAndSearching<T extends Comparable<T>> {

    /**
     * 10.1 Sorted Merge: Given two sorted arrays A and B where A has large enough buffer to hld B at the end.
     * Write method to merge B into A in sorted order.
     */
    public void sortedMerge(T[] A, T[] B) {

        if (B == null || B.length < 1)
            return;

        //First find number of elements in A
        int numA = 0;
        while (A[numA] != null) {
            numA++;
        }

        int cur1 =0, cur2=0;
        while (cur2 < B.length) {
            int compare = A[cur1+cur2].compareTo(B[cur2]);

            if(compare > 0) {
                int j = numA + cur2 -1;
                while (j >= cur1 + cur2) {
                    A[j+1] = A[j];
                    j--;
                }
                A[cur1+cur2] = B[cur2];
                cur2++;
            } else
                cur1++;
        }


        /**
         *
         * second solution
         */
        /*
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
        */
    }

    /**
     * 10.2 Group Anagrams - Write a method to sort an array of strings so that anagrams are next to each other.
     */
    private class AnagramComparator implements Comparator<String> {

        private String sort(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        @Override
        public int compare(String o1, String o2) {
            String sortedStr1 = sort(o1);
            String sortedStr2 = sort(o2);

            if (sortedStr1.equals(sortedStr2))
                return 0;
            else
                return o1.compareTo(o2);
        }
    }
    public String[] groupAnagrams(String[] strs) {
        Arrays.sort(strs, new AnagramComparator());
        return strs;
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
            if ((elem >= intArr[start] && elem < intArr[mid]) || (elem >= intArr[start] && elem > intArr[mid])) {
                return searchInRotatedArrayHelper(elem, intArr, start, mid);
            } else if ((elem > intArr[mid] && elem <= intArr[end]) || (elem < intArr[mid] && elem > intArr[mid])) {
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
     * 10.5 Sparse Search: Given a sorted array of strings that is interspersed with empty strings,
     * write a method to find the location of a given string.
     * Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
     * Output: 4
     */
    public int sparseSearch(String word, String[] stringCol) {
        return sparseSearchHelper(word, stringCol, 0, stringCol.length-1);
    }

    private int sparseSearchHelper(String word, String[] stringCol, int start, int end) {
        int mid = (start + end)/2;

        if (stringCol[mid] == "") {
            int leftMid = mid-1;
            int rightMid = mid+1;

            while(leftMid >= 0 && rightMid < stringCol.length-1) {

                if (stringCol[leftMid] != "") {
                    mid = leftMid;
                    break;
                }

                if (stringCol[rightMid] != "") {
                    mid = rightMid;
                    break;
                }
                leftMid--;
                rightMid++;
            }
        }

        if (start < end) {
            if (word.compareTo(stringCol[mid]) == 0)
                return mid;
            else if (word.compareTo(stringCol[mid]) < 0)
                return sparseSearchHelper(word, stringCol, start, mid-1);
            else
                return sparseSearchHelper(word, stringCol, mid+1, end);
        }

        return -1;
    }

    /**
     * 10.6 Sort Big File: Imagine you have 20GB file with one string per line. Explain how would you sort this file.
     * 10.7 Missing Integer: Given an input file with four billion non-negative integers, provide an algorithm to generate
     * an integer that is not contained in the file. Assume you have 1GB memory. Then, assume you have 10MB memory.
     *
     */

    /**
     * 10.8 Find duplicates: You have an array with all numbers from 1 to N., where N is at most 32,000.
     * Array might have duplicate entries and you don't know what N is. With only 4 kilobytes of memory available,
     * how would you print all duplicate elements.
     */


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

    /**
     * 10.10 Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish
     * to be able to look up the rank of a number x (number of values less than or equal to x). Implement the
     * data structures and algorithms to support these operations. That is, implement the method track(int x),
     * which is called when each number is generated, and the method getRankOfNumber(int x), which returns
     * the number of values less than or equal to x (not including x itself).
     *
     * Example: Stream -> 5, 1, 4, 4, 5, 9, 7, 13, 3
     * getRankOfNumber(1)=0
     * getRankOfNumber(3)=1
     * getRankOrNumber(5)=4
     */
    public int rankOfNumber(Integer[] stream, int inputInt) {
        Arrays.sort(stream);
        int i =0;
        for (;i<stream.length; i++) {
            if (stream[i] == inputInt)
                break;
        }
        return i;
    }
}
