package InterviewProblems.ElementsOfProgrammingInterviews;

import java.util.*;

public class HashTables {

    /**
     * 12.3 Nearest Repetition: People do not like reading text in which word is used multiple times.
     * Write a function which identifies closest pair of equal entities.
     */
    public String nearestRepetition(String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
        HashMap<String, Integer> wordMap = new HashMap<>();

        //First scan to insert words with distacnes
        int min = Integer.MAX_VALUE;
        String wordMin = "";
        for (String aWord : words) {

            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                if (entry.getKey().equals(aWord)) {
                    if (entry.getValue() < min) {
                        min = entry.getValue();
                        wordMin = entry.getKey();
                    }
                    entry.setValue(0);
                }
                entry.setValue(entry.getValue()+1);
            }

            if (!wordMap.containsKey(aWord)) {
                wordMap.put(aWord, 0);
            }
        }

        return wordMin;
    }

}


