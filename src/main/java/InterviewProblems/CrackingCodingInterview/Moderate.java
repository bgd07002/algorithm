package InterviewProblems.CrackingCodingInterview;

import java.util.Arrays;

public class Moderate {

    /**
     * 16.1 Number Swapper: Write a function to swap a number in place (i.e. without temporary variables)
     */
    public int[] numberSwapper(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a,b};
    }

    /**
     * 16.2 Word Frequencies: Design a method to find the frequency of occurrences of any given word in a book.
     * What if we were running this algorithms multiple times?
     */
    public int wordFrequency(String text, String word) {
        //To specifically split on white space and the apostrophe
        //String[] tokens = text.split("[\\s']");

        //Or to split on any non word character
        String[] tokens = text.split("[\\W]");

        int freq = 0;
        for (String s : tokens) {
            if (s.equalsIgnoreCase(word))
                freq++;
        }
        return freq;
    }

    /**
     * 16.3 Line Intersection
     * 16.4 Tic Tac Toe Win: Design an algorithm to figure out if someone won a game of tic tac toe.
     */
    public boolean ticTacToeWon(int[][] ticTacToeBoard) {
        if (ticTacToeBoard.length != ticTacToeBoard[0].length || ticTacToeBoard.length != 3)
            return false;

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        int[] columnSum = new int[ticTacToeBoard.length];

        for (int i=0; i < ticTacToeBoard.length; i++) {
            int rowSum = 0;
            for (int j =0; j < ticTacToeBoard[i].length; j++) {
                if (ticTacToeBoard[i][j] > 1 || ticTacToeBoard[i][j] < -1)
                    return false;

                rowSum += ticTacToeBoard[i][j];
                columnSum[j] += ticTacToeBoard[i][j];

                //Diagonal Validation
                if (i == j)
                    diagonalSum1 += ticTacToeBoard[i][j];

                if (i + j == ticTacToeBoard.length-1)
                    diagonalSum2 += ticTacToeBoard[i][j];
            }
            //Validating rows
            if (rowSum == 3 || rowSum == -3)
                return true;
        }

        if (diagonalSum1 == 3 || diagonalSum1 == -3 || diagonalSum2 == 3 || diagonalSum2 == -3)
            return true;

        for (int colSum : columnSum) {
            if (colSum == 3 || colSum == -3)
                return true;
        }

        return false;
    }

    /**
     * 16.5 Factorial Zeros: Write an algorithm which computes the number of trailing zeros in n factorial.
     */
    public int factorialZeros(int n) {

        int totalFiveMultiples = 0;
        for (int i =1; i <= n; i++) {
            if (i % 5 ==0) {
                int temp = i;
                while (temp % 5 == 0) {
                    totalFiveMultiples++;
                    temp /=5;
                }
            }
        }
        return totalFiveMultiples;
    }

    /**
     * 16.6 Smallest Difference: Given two arrays of integers, compute the pair of values (one value to each array)
     * with smallest non-negative difference.
     * Input: {1,3,15,11,2} and {23, 127, 235, 19, 8}
     * Output: 3 from pair {11,8}
     */
    public int smallestDifferenceIntArr(int[] arr1, int[] arr2) {
        //O(nlogn)
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int min = Math.max(Math.abs(arr2[arr2.length-1]-arr1[0]), Math.abs(arr1[arr1.length-1]-arr2[0]));
        //Complexity -> O(nlogn)
        for (int i=0; i < arr1.length; i++) {
            int diff = Math.max(Math.abs(arr2[arr2.length-1]-arr1[i]), Math.abs(arr2[0]-arr1[i]));
            diff = smallestDifferenceIntArrHelper(arr2, diff, arr1[i], 0, arr2.length-1);
            if (diff < min)
                min = diff;
        }
        return min;
    }

    private int smallestDifferenceIntArrHelper(int[] arr, int diff, int num, int start, int end) {
        int mid = (start+end)/2;
        int tempDiff = diff;

        if (Math.abs(arr[mid]-num) < diff) {
            tempDiff = Math.abs(arr[mid] - num);
            if (arr[start] <= num && num < arr[mid])
                return smallestDifferenceIntArrHelper(arr, tempDiff, num, start, mid-1);
            else if (num > arr[mid] && num <= arr[end])
                return smallestDifferenceIntArrHelper(arr, tempDiff, num, mid+1, end);
            else if (num < arr[start])
                return Math.abs(arr[start] - num);
            else
                return Math.abs(arr[end] - num);
        }
        else
            return tempDiff;
    }

    /**
     * 16.7 Number Max: Write a method to find the maximum of two numbers. You shouldn't use if-else or any other
     * comparison method. (???)
     */
    public int maxWithoutBranching(int a, int b) {
        int sigBitInInt = Integer.valueOf("0x80000000", 16).intValue();
        int signBitValue = ((a-b) | sigBitInInt);

        if (signBitValue > 0)
            return a;
        else
            return b;
    }

    /**
     * 16.8 English Int: Given an integer, print an English phase that describes the integer
     * (One Thousand Two Hundred Thirty Four )
     */

    /**
     * 16.9 Operations: Write methods to implement multiply, substract, and divide operations for integers.
     * Results of all of these are integers. Use only add operator.
     */
}
