package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bdundar on 8/17/2017.
 */
public class Strings {

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
