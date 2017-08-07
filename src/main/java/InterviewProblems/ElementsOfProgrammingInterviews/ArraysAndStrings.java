package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class ArraysAndStrings {

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
     * 6.18 Run-Length Encoding
     * Encoding: aaaabcccaa -> 4a1b3c2a
     */
    public String runLengthEncoding(String s) {
        if (s == null || s.length() == 0)
            return null;

        StringBuilder sb = new StringBuilder();

        char[] sArr = s.toCharArray();
        char prevChar = sArr[0];
        int charRepetitionCount =1;
        for (int i=1; i < sArr.length; i++) {
            if (sArr[i] != prevChar) {
                sb.append(charRepetitionCount).append(prevChar);
                prevChar = sArr[i];
                charRepetitionCount = 1;
            }
            else
                charRepetitionCount++;

        }
        sb.append(charRepetitionCount).append(prevChar);
        return sb.toString();
    }

    public String runLengthDecoding(String s) {
        StringBuilder sb = new StringBuilder();

        char[] sArr = s.toCharArray();
        int repetitionNumber = 0;
        for (int i=0; i< sArr.length; i++) {
            if (Character.isDigit(sArr[i]))
                repetitionNumber = 10*repetitionNumber + (int)sArr[i] -48;
            else if (Character.isAlphabetic(sArr[i])) {
                while (repetitionNumber > 0) {
                    sb.append(sArr[i]);
                    repetitionNumber--;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 6.19 Reverse All Words
     * Example: Alice Likes Bob -> Bob Likes Alice
     */
    public String reverseWords(String sentence) {
        StringBuilder sbReversed = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = words.length-1; i >=0; i--)
            sbReversed.append(words[i]).append(" ");

        return sbReversed.toString().trim();
    }

    /**
     * 6.20 Find the first occurrence of a substring
     */
    public int findFirstOccurenceString(String substring, String text) {

        char[] textArr = text.toCharArray();
        char[] substringArr = substring.toCharArray();

        int track = 0;
        for (int i=0; i< textArr.length; i++) {
            if (textArr[i] == substringArr[track]) {
                track++;
                if (track == substring.length())
                    return i-track+1;
            }else
                track = 0;
        }
        return -1;
    }



    /**
     * 6.21 Replace and Remove: Write a function that takes an array string and replaces "a" with "dd" and removes "b".
     * Assumes s is stored in an array that has enough storage for the final result. You use O(1) additional storage.
     */
    public String replaceAndRemove(char[] s) {

        //First we remove 'b' and count a
        int countA = 0;
        int len =0;
        for (int i=0; i <= s.length-1 && s[i] != '\u0000'; i++) {
            if (s[i] == 'a' || s[i] == 'A')
                countA++;

            if (s[i] == 'b' || s[i] == 'B') {
                int j =i;
                while (s[j] != '\u0000') {
                    s[j] = s[j+1];
                    j++;
                }
                i--;
                len--;
            }
            len++;
        }

        //Now we replace 'a' with 'dd'
        for (int i= len-1; i>= 0; i--) {
            if (s[i] == 'a' || s[i] == 'A') {
                s[i+countA-1] = 'd';
                s[i+countA] = 'd';
                countA--;
            } else {
                s[i+countA] = s[i];
            }
        }

        return new String(s).trim();
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
