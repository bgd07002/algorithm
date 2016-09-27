package InterviewProblems.CrackingCodingInterviews;

import java.util.*;

public class StringsArrays {

    /**
     * 1.1 Is Unique - Implement an algorithm to determine if a string has all unique characters. What
     * if you cannot use additional data structures?
     */
    public boolean isStringUniqueChars(String inputStr) {

        if (inputStr == null || inputStr.length() > 256 )
            return false;

        boolean[] charArr = new boolean[256];
        for (char ch : inputStr.toCharArray()) {

            int idx = (int)ch;
            if (charArr[idx])
                return false;
            else
                charArr[idx] = true;
        }
        return true;
    }

    /**
     * 1.2 Check Permutation - Given two strings, write a method to decide if one is a permutation of the other.
     */
    public boolean isAnagram(String sOriginal, String sPermuted) {
        if (sOriginal.length() != sPermuted.length())
            return false;

        int[] intArray = new int[256];
        for (char ch : sOriginal.toCharArray()) {
            intArray[(int)ch]++;
        }

        for (char ch: sPermuted.toCharArray()) {
            if (intArray[(int)ch] < 1)
                return false;
            else
                intArray[(int)ch]--;
        }
        return true;
    }

    /**
     * 1.3 URLify - Write a method to replace all spaces in a string with'%20'.
     */
    public String replaceSpaceChars(String inputStr) {
        StringBuilder sb = new StringBuilder();

        for (char ch : inputStr.toCharArray()) {
            if (ch != ' ')
                sb.append(ch);
            else
                sb.append("%20");
        }
        return sb.toString();
    }

    /**
     * Implement a function void reverse(char* str) in Cor C++ which reverses a null-terminated
     * string.
     */
    public String reverseString(String str) {

        if (str == null || str.length() <= 1 )
            return str;

        char[] strArr = str.toCharArray();
        for (int i=0; i < strArr.length - i; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[str.length()-i-1];
            strArr[str.length()-i-1] = temp;
        }
        return new String(strArr);
    }

    /**
     * 1.5 Test whether a string was edited by 1 character. Edit happens by
     * adding, removing and changing character. Examples:
     * pale, ple -> true
     * pales, pale -> true
     * pale, bale -> true
     * pale, bake -> false
     */
    public boolean isEditByOneChar(String str, String editedStr) {
        int diff = str.length() - editedStr.length();
        if (diff >1 || diff < -1)
            return false;

        char[] strArr = str.toCharArray();
        char[] editedStrArr = editedStr.toCharArray();

        int i=0,j=0;
        boolean oneDifference = false;
        while (i < strArr.length && j < editedStrArr.length) {
            if (strArr[i] == editedStrArr[j]) {
                i++;
                j++;
            } else {
                if (oneDifference)
                    return false;

                oneDifference = true;
                //Add case
                if (editedStrArr.length > strArr.length)
                    j++;
                else if (editedStrArr.length < strArr.length) //remove case
                    i++;
                else {
                    i++;
                    j++;
                }
            }
        }

        return true;
    }

    /**
     * 1.6 Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become
     * a2blc5a3. If the "compressed" string would not become smaller than the original
     * string, your method should return the original string.
     */
    public String stringCompression(String inputStr) {
        StringBuilder sb = new StringBuilder();
        char[] inputArr = inputStr.toCharArray();

        for (int i=0; i < inputArr.length; ) {
            char temp = inputArr[i];
            int compNumber = 1;
            int j= i+1;
            do {
                if (j == inputArr.length || inputArr[j] != temp) {
                    sb.append(inputArr[i])
                            .append(compNumber);
                    i = j;
                    break;
                } else {
                    compNumber++;
                }
                j++;
            } while (j <= inputArr.length);
        }

        return (sb.length() < inputStr.length()) ? sb.toString() : inputStr;
    }

    /**
     * 1.7 Given an image with NxN matrix where each pixes is 4 bytes. Write a method that rotate
     * the image by 90 degrees in place.
     */
    public int[][] rotateMatrixBy90Degrees(int[][] matrix) {
        int arrLength = matrix.length;

        for (int sum=0; sum< 2*(arrLength-1); sum++) {
            int j;
            for (int i=0; i <= sum; i++) {
                if (i < arrLength && sum-i< arrLength && i < sum-i) {
                    j = sum-i;
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        return matrix;
    }

    /**
     * 1.8 Zero Matrix: If an element of MxN matrix is 0, its entire row and column is set to 0.
     */
    public int[][] zeroizeRowAndColumn(int[][] matrix) {
        SortedSet<Integer> rowsDeleted = new TreeSet<>();
        SortedSet<Integer> columnsDeleted = new TreeSet<>();

        for (int i=0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsDeleted.add(i);
                    columnsDeleted.add(j);
                }
            }
        }

        for (int aRow : rowsDeleted) {
            for (int j =0; j < matrix[aRow].length; j++)
                matrix[aRow][j] = 0;
        }

        for (int aColumn : columnsDeleted) {
            for (int j =0; j < matrix.length; j++) {
                matrix[j][aColumn] = 0;
            }
        }
        return matrix;
    }

    /**
     * Helper function for problem 1.9
     */
    private boolean isSubString(String str1, String str2) {
        return str1.contains(str2);
    }


    /**
     * 1.9 String Rotation: Write code to check if s2 is a rotation of s1 using only call to IsSubstring().
     * (e.g. "waterbottle" is a rotation of "erbottlewat")
     */
    public boolean isRotation(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        int i =0;
        while (i < str2.length() && isSubString(str1, str2.substring(0,i))) {
            i++;
        }

        if (isSubString(str1, str2.substring(i)))
            return true;

        return false;
    }
}
