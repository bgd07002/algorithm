package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bdundar on 8/17/2017.
 */
public class Strings {

    /**
     * 7.1 String Integer Encoding: "123" -> 123, "-123" -> -123, "123bc" -> Exception
     * Edge Cases: Max integer
     */
    public int stringIntegerEncoding(String str) {
        if (!str.matches("[0-9-]+"))
            return -1;

        char[] strArr = str.toCharArray();
        int number = (strArr[0] != '-') ? Character.getNumericValue(strArr[0]) : 0;
        for (int i =1; i < strArr.length; i++) {
            number = 10*number + Character.getNumericValue(strArr[i]);
        }
        return (strArr[0] == '-')? -number : number;
    }

    /**
     * 7.2 Base Conversion: Write a function that performs the base conversion for 2 <= b <= 16
     */
    public String baseConversion(int num, int base) {

        if (base > 16 || base < 2)
            return null;

        StringBuilder sb = new StringBuilder();
        char[] hexaMapping = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        int numPositive = (num < 0)? -num: num;
        while (numPositive > 0) {
            sb.append(hexaMapping[numPositive % base]);
            numPositive /=base;
        }

        return sb.append((num < 0)? "-" : "").reverse().toString();
    }

    /**
     * 7.3 Spreadsheet Column Encoding: Convert id into A, B,...,Z, AA, AB,..., AZ,..., ZZ ,AAA, AAB,...
     */
    public String spreadsheetEncoding(int id) {
        if (id < 0)
            return null;

        StringBuilder sbEncoding = new StringBuilder();
        char[] alphabetEnc = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int alphabetSize = alphabetEnc.length;

        while (id >= 26) {
            sbEncoding.append(alphabetEnc[(id % alphabetSize)]);
            id = (id - alphabetSize)/alphabetSize;
        }
        sbEncoding.append(alphabetEnc[(id % alphabetSize)]);
        return sbEncoding.reverse().toString();
    }

    /**
     * 7.4 Replace and Remove: Write a function that takes an array string and replaces "a" with "dd" and removes "b".
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

    /**
     * 7.6 Reverse All Words
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
     * 7.7 Phone Number Mnemonic: Given a cell phone keypad
     * 2-> {ABC}, 3-> {DEF}, 4-> {GHI}, 5->{JKL}, 6->{MNO}, 7->{PQRS}, 8-> {TUV}, 9-> {WXYZ}
     * Return all possible char sequences that corresponds to number sequence.
     * Example: 2276696 -> {ACRONYM, ABPOMZN, ...}
     */
    public ArrayList<StringBuilder> phoneNumberWords(int[] pNum) {
        HashMap<Integer, String[]> phoneMap = new HashMap<>();
        phoneMap.put(0, new String[]{});
        phoneMap.put(1, new String[]{});
        phoneMap.put(2, new String[]{"A", "B", "C"});
        phoneMap.put(3, new String[]{"D", "E", "F"});
        phoneMap.put(4, new String[]{"G", "H", "I"});
        phoneMap.put(5, new String[]{"J", "K", "L"});
        phoneMap.put(6, new String[]{"M", "N", "O"});
        phoneMap.put(7, new String[]{"P", "Q", "R", "S"});
        phoneMap.put(8, new String[]{"T", "U", "V"});
        phoneMap.put(9, new String[]{"W", "X", "Y", "Z"});

        ArrayList<StringBuilder> outputList = new ArrayList<>();
        for (int i=0; i< pNum.length; i++) {
            String[] letterMap = phoneMap.get(pNum[i]);

            List<StringBuilder> tempList = new ArrayList<>();
            for (int j =0; j< letterMap.length; j++) {
                for (StringBuilder sbOutputList : outputList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(sbOutputList).append(letterMap[j]);
                    tempList.add(sb);
                }

                if (outputList.isEmpty())
                    tempList.add(new StringBuilder(letterMap[j]));
            }
            outputList.clear();
            outputList.addAll(tempList);
        }
        return outputList;
    }


    /**
     * 7.11 Write string sinusoidally
     * 7.12 Run length encoding (Cracking Coding Interview 1.6)
     */
    public String stringSinusoidally(String str, int verticality) {

        StringBuilder[] sbArr = new StringBuilder[verticality];

        char[] strArr = str.toCharArray();
        int idx =0;
        boolean isIncreasing = true;
        for (int j=0; j<strArr.length; j++) {
            if (sbArr[idx] == null)
                sbArr[idx] = new StringBuilder();

            sbArr[idx].append(strArr[j]);

            //Logic at border points
            if (isIncreasing && idx == verticality-1)
                isIncreasing = false;
            else if (!isIncreasing && idx == 0)
                isIncreasing = true;

            idx = (isIncreasing)? idx+1: idx-1;
        }

        //Concatenate these string builders
        StringBuilder sb = new StringBuilder();
        for (StringBuilder aStrBld: sbArr)
            sb.append(aStrBld);

        return sb.toString();
    }

    /**
     * 7.13 Find the first occurrence of a substring
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
}
