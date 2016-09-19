package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.ArrayList;
import java.util.HashMap;

public class ArraysAndStrings {

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

        /*
        for (StringBuilder sb : outputList) {
            if (sb.length() < pNum.length)
                outputList.remove(sb);
        }
        */

        return outputList;
    }

    /*
    private ArrayList<StringBuilder> phoneNumberWordsHelper(HashMap<Integer, String[]> phoneMap,
                                                            ArrayList<StringBuilder> outputList,
                                                            int aNum) {
        String[] chars = phoneMap.get(aNum);
        for (String achar : chars) {

            if

            for (StringBuilder sb : outputList) {
                sb.append(achar);
            }
            phoneNumberWordsHelper(phoneMap, outputList, aNum);
        }
    }
    */
}
