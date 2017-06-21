package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.HashMap;

public class ArraysAndStrings {

    /**
     * 6.3 Max Difference: max(A[i]-A[j]) where i>j
     */
    public int maxDifferenceArray(int[] numArr) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<numArr.length; i++) {
            for (int j = i; j<numArr.length; j++) {
                max = ((numArr[j] - numArr[i]) > max) ? numArr[j] - numArr[i] : max;
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
     * 6.21 Replace and Remove: Write a function that takes an array string and replaces "a" with "dd" and removes "b".
     * Assumes s is stored in an array that has enough storage for the final result. You use O(1) additional storage.
     */
    public String replaceAndRemove(char[] s) {

        int i =0;
        while (i < s.length && s[i] !='\u0000') {
            if (s[i] == 'a' || s[i] == 'A') {
                s[i] = 'd';
                for (int j = s.length-1; j>i+1; j--) {
                    s[j] = s[j-1];
                }
                s[i+1] = 'd';
                i++;
            }

            if (s[i] == 'b' || s[i] == 'B') {
                for (int j = i; j < s.length-1; j++) {
                    s[j] = s[j+1];
                }
                continue;
            }
            i++;
        }
        return String.copyValueOf(s).replace("\u0000","");
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
     * 6.22 Phone Number Mnemonic: Given a cell phone keypad
     * 2-> {ABC}, 3-> {DEF}, 4-> {GHI}, 5->{JKL}, 6->{MNO}, 7->{PQRS}, 8-> {TUV}, 9-> {WXYZ}
     * Return all possible char sequences that corresponds to number sequence.
     * Example: 2276696 -> {ACRONYM, ABPOMZN, ...}
     */
    public ArrayList<StringBuilder> phoneNumberWords(int[] pNum) {
        HashMap<Integer, String[]> phoneMap = new HashMap<>();
        phoneMap.put(0, new String[]{""});
        phoneMap.put(1, new String[]{""});
        phoneMap.put(2, new String[]{"A", "B", "C"});
        phoneMap.put(3, new String[]{"D", "E", "F"});
        phoneMap.put(4, new String[]{"G", "H", "I"});
        phoneMap.put(5, new String[]{"J", "K", "L"});
        phoneMap.put(6, new String[]{"M", "N", "O"});
        phoneMap.put(7, new String[]{"P", "Q", "R", "S"});
        phoneMap.put(8, new String[]{"T", "U", "V"});
        phoneMap.put(9, new String[]{"W", "X", "Y", "Z"});

        ArrayList<StringBuilder> outputList = new ArrayList<>();
        for (int aNum : pNum) {
            String[] chars = phoneMap.get(aNum);
            if (outputList.size() == 0) {
                for (String s : chars) {
                    StringBuilder sb = new StringBuilder(s);
                    outputList.add(sb);
                }
            } else {
                ArrayList<StringBuilder> tempList = new ArrayList<>();
                for (int i =0; i < outputList.size(); i++) {
                    for (String s : chars) {
                        StringBuilder sbNew = new StringBuilder();
                        sbNew.append(outputList.get(i).toString()).append(s);
                        tempList.add(sbNew);
                    }
                }
                outputList.clear();
                outputList.addAll(tempList);
            }
        }
        return outputList;
    }

    /**
     * 7.5 Test Palindromicity: When removing all non-alphabetic characters it reads the same from
     * front to back ignoring the case.
     */
    public boolean testPalindromicity(String s) {
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] sArr = s.toCharArray();

        int i=0;
        while (i < sArr.length-1-i) {
            if (sArr[i] != sArr[sArr.length-1-i])
                return false;
            i++;
        }
        return true;
    }


}
