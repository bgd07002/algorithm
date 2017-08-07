package InterviewProblems.CrackingCodingInterviews;

import Utility.CommonFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        if (intArr[mid] == elem)
            return mid;

        if (mid > start) {
            if (elem >= intArr[start] && elem < intArr[mid])
                return searchInRotatedArrayHelper(elem, intArr, start, mid);
            else if (elem >= intArr[start] && elem > intArr[mid] && elem > intArr[end])
                return searchInRotatedArrayHelper(elem, intArr, start, mid);
            else if (elem > intArr[mid] && elem <= intArr[end])
                return searchInRotatedArrayHelper(elem, intArr, mid+1, end);
            else
                return searchInRotatedArrayHelper(elem, intArr, mid+1, end);
        } else
            return -1;
    }


    /**
     * 10.4 Sorted Search, No Size: You are given an array-like structure Listy which lacks size method.
     * It does have an elementAt(i) method in O(1) time. If i is out of bounds, it returns -1 (data structure only
     * supports positive integers). Given Listy which contains sorted, positive integers, find the index at which
     * element x occurs. If x occurs multiple times, you may return any index.
     */
    public int searchIdxSortedArray(int x, int[] intArr) {
        int length = findLength_10_4(intArr);
        return searchIdxSortedArrayHelper(x, intArr, 0 , length-1);
    }

    private int searchIdxSortedArrayHelper(int x, int[] intArr, int start , int end) {
        int mid = (start + end)/2;
        if (intArr[mid] == x)
            return mid;

        if (mid > start) {
            if (x >= intArr[start] && x < intArr[mid])
                return searchIdxSortedArrayHelper(x, intArr, start , mid);
            else if (x <= intArr[end] && x > intArr[mid])
                return searchIdxSortedArrayHelper(x, intArr, mid , end);
        }
        return -1;
    }

    private int findLength_10_4(int[] intArr) {
        if (intArr[0] == -1)
            return 0;
        if (intArr[1] == -1)
            return 1;
        return findLength_10_4_recursive(1, intArr);
    }

    private int findLength_10_4_recursive(int query, int[] intArr) {
        if (intArr[query] != -1)
            return findLength_10_4_recursive(2*query, intArr);
        else {
            for (int i = query/2+1; i < query; i++) {
                if (intArr[i] == -1)
                    return i;
            }
        }
        return 0;
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

        int mid = (start+end)/2;
        int leftMid = mid-1;
        int rightMid = mid+1;

        if (stringCol[mid] == "") {
            while (leftMid >= start && rightMid <= end ) {
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
            if (stringCol[mid] == "")
                return -1;
        }

        if (start < end) {
            if (word.compareTo(stringCol[mid]) > 0)
                return sparseSearchHelper(word, stringCol, mid+1, end);
            else if (word.compareTo(stringCol[mid]) < 0)
                return sparseSearchHelper(word, stringCol, start, mid-1);
            else
                return mid;
        }

        return -1;
    }

    /**
     * 10.6 Sort Big File: Imagine you have 20GB file with one string per line. Explain how would you sort this file.
     * External sorting ->
     * Divide file into chunks
     * Each chunk is sorted separately and then stored into file system
     * Once sorting of chunks are finished, merge these one by one.
     */


     /**
      * 10.7 Missing Integer: Given an input file with four billion non-negative integers, provide an algorithm to generate
      * an integer that is not contained in the file. Assume you have 1GB memory. Then, assume you have 10MB memory.
      *
      * Solution: 2^32 integers (or 4 million integers) and 2^31 non-negative integers. 1 GB of memory or 8 million bits. Map all integers to distinct bit.
      *
      * 1. Create a bit vector with 4 million bits. Do so with integer array where each int represented by 32 Boolean values
      * 2. Initialize bit vector with 0s
      * 3. Scan all numbers and call BV.set(num,1)
      * 4. Scan again to find first index with value of 0.
      *
      */
    public int missingInteger1GBMemory() throws IOException {

        byte[] bitVector = new byte[(byte)Math.pow(2,27)];
        try(BufferedReader br = new BufferedReader(new FileReader("FourBillionIntegers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                byte num = Byte.parseByte(line);
                int bucketNumber = (num >> 5) + 1;
                int insideBucketLocation = num % 32;
                bitVector[bucketNumber] = (byte)insideBucketLocation;
            }
        }

        //for (int num : bitVector) {
        //    if (num != 31)
        //}
        return -1;
    }

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

    /**
     * 10.11
     */
}
