package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.*;

public class Arrays {

    /**
     * 6.2 Increment Array Integer
     * 6.3 Multiplication of Array Integer
     */
    public class BigInteger {

        /**
         * Assuming arrays are not null and have length at least 1
         * Again assuming each digit is <= 9 and >= 0
         */
        public ArrayList<Integer> add(ArrayList<Integer> a1, ArrayList<Integer> a2) {
            if ((a1.get(0) < 0 && a2.get(0) > 0) || (a1.get(0) > 0 && a2.get(0) < 0))
                return substract(a2, a1);

            boolean isNegative = false;
            if (a1.get(0) < 0 && a2.get(0) < 0) {
                isNegative = true;
                a1.set(0, a1.get(0)*(-1));
                a2.set(0, a2.get(0)*(-1));
            }

            ArrayList<Integer> sum = new ArrayList<>();
            int cur1 = a1.size()-1;
            int cur2 = a2.size()-1;

            int carryOver = 0;
            while (cur1 >= 0 || cur2 >= 0) {
                int a1Num = (cur1 >= 0)? a1.get(cur1): 0;
                int a2Num = (cur2 >= 0)? a2.get(cur2): 0;

                sum.add((a1Num+a2Num+carryOver)%10);
                carryOver = (a1Num+a2Num+carryOver) > 10? 1 : 0;
                cur1--;
                cur2--;
            }
            if (carryOver > 0)
                sum.add(carryOver);

            Collections.reverse(sum);
            if (isNegative)
                sum.set(0, sum.get(0)*(-1));
            return sum;
        }

        public ArrayList<Integer> substract(ArrayList<Integer> a1, ArrayList<Integer> a2) {

            if ((a1.get(0) > 0 && a2.get(0) < 0) || (a1.get(0) < 0 && a2.get(0) > 0))
                return add(a1, a2);

            if (a1.get(0) > 0 && a2.get(0) > 0)
                return subtractHelper(a1, a2, (a1.size() >= a2.size()));

            if (a1.get(0) < 0 && a2.get(0) < 0)
                return subtractHelper(a2, a1, (a2.size() >= a1.size()));

            return null;
        }

        private ArrayList<Integer> subtractHelper(ArrayList<Integer> a1, ArrayList<Integer> a2, boolean isLarger) {
            ArrayList<Integer> subtraction = new ArrayList<>();
            int cur1 = a1.size()-1;
            int cur2 = a2.size()-1;
            int carryOver = 0;
            while (cur1 >= 0 && cur2 >= 0) {
                int sub = a1.get(cur1)-a2.get(cur2)-carryOver;
                if (sub >= 0) {
                    subtraction.add(sub);
                    carryOver = 0;
                } else {
                    subtraction.add(10 + sub);
                    carryOver = 1;
                }
                cur1--;
                cur2--;
            }

            while (cur1 >= 0) {
                if (a1.get(cur1)-carryOver >= 0) {
                    subtraction.add(a1.get(cur1)-carryOver);
                    carryOver = 0;
                } else {
                    subtraction.add(10 + a1.get(cur1)-carryOver);
                    carryOver = 1;
                }
                cur1--;
            }
            return null;
        }

        public int[] multiply(int[] a1, int[] a2) {
            return null;
        }
    }


    /**
     * 6.3 Max Difference: max(A[i]-A[j]) where i>j
     */
    public int maxDifferenceArray(int[] numArr) {
        int max = Integer.MIN_VALUE;

        for (int i =1; i < numArr.length; i++) {
            for (int j=0; j<i; j++) {
                max = (numArr[i]-numArr[j] > max)? numArr[i]-numArr[j]: max;
            }
        }
        return max;
    }

    /**
     * 6.5 Subset of (A[i] with i in [0,n-1])summing to 0 mod n where n is the array length
     */
    public ArrayList<Integer> subsetSumZero(int[] numArr) {
        return null;
    }


    /**
     * 6.5 Delete duplicates from sorted array
     * If additional memory allowed O(N), otherwise O(N^2)
     */
    public void removeDuplicatesFromSortedArray(int[] sortedArr) {

        int cur2;
        //aaabbcc cur1 =0, cur2=3
        int diff = 0;
        for (int cur1=0; cur1< sortedArr.length; cur1++) {
            for (cur2= cur1+1; cur2 < sortedArr.length; cur2++) {
                if (sortedArr[cur1] != sortedArr[cur2]) {
                    break;
                }
            }
            diff = cur2 -cur1-1;

            //Move elements
            //Optimize this part
            for (int i=cur2; i < sortedArr.length+diff; i++) {
                if (i<sortedArr.length)
                    sortedArr[i-diff] = sortedArr[i];
                else
                    sortedArr[i-diff] =0;
            }
        }
    }


    /**
     * 6.6 Longest Increasing Subarray
     * An array is increasing if each element is less than the last element
     */
    public int[] longestIncreasingSubarray() {
        int[] beginEndIndices = new int[2];
        return beginEndIndices;
    }

    /**
     * 6.16 Sudoku Checking Algorithm
     * Assumption: We assume 0 for empty rows
     */
    public boolean checkSudoku(int[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        if (checkSudokuRows(board) && checkSudokuColumns(board) && checkSudokuCubiclesAll(board))
            return true;

        return false;
    }

    private boolean checkSudokuRows(int[][] board) {
        boolean[] checkingArr;
        for (int i =0; i < board.length; i++) {
            checkingArr = new boolean[10];
            for (int j =0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    if (checkingArr[board[i][j]])
                        return false;
                    else
                        checkingArr[board[i][j]] = true;
                }
            }
        }
        return true;
    }

    private boolean checkSudokuColumns(int[][] board) {
        boolean[] checkingArr;
        for (int k =0; k < board[0].length; k++) {
            checkingArr = new boolean[10];
            for (int i =0; i < board.length; i++) {
                if (board[i][k] != 0) {
                    if (checkingArr[board[i][k]])
                        return false;
                    else
                        checkingArr[board[i][k]] = true;
                }
            }
        }
        return true;
    }

    private boolean checkSudokuCubiclesAll(int[][] board) {
        for (int i =0; i < board.length ; i+=3)
            for (int j=0; j < board[i].length; j+=3)
                if(!checkSudokuCubicles(board, i, j))
                    return false;

        return true;
    }

    private boolean checkSudokuCubicles(int[][] board, int i, int j) {
        boolean[] checkingArr = new boolean[10];
        for (int k =0; k < 3 ; k++) {
            for (int m = 0; m < 3; m++) {
                if (board[i + k][m + j] != 0) {
                    if (checkingArr[board[i + k][m + j]])
                        return false;
                    else
                        checkingArr[board[i + k][m + j]] = true;
                }
            }
        }
        return true;
    }

    /**
     * 6.19 Computes Pascal triangle
     */
    public List<int[]> computePascalTriangle(int n) {
        if (n <1)
            return null;

        List<int[]> listOfTriangles = new ArrayList<>();
        return pascalRowList(n, listOfTriangles);
    }

    private List<int[]> pascalRowList(int n, List<int[]> listOfTriangles) {
        if (n == 2) {
            listOfTriangles.add(new int[]{1});
            listOfTriangles.add(new int[]{1, 1});
        }
        else {
            int[] previousRow = pascalRowList(n-1, listOfTriangles).get(n-2);
            int[] lastRow = new int[n];
            lastRow[0]=1;
            lastRow[n-1]=1;
            for (int i=1; i<n-1; i++)
                lastRow[i] = previousRow[i-1]+previousRow[i];
            listOfTriangles.add(lastRow);
        }
        return listOfTriangles;
    }
}
