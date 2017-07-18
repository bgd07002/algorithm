package Courses.CS373Spring16.HW4_ComparingLiterary;

import Utility.CommonFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ComparingLiterary {

    private ArrayList<String> textWords;
    private LinkedHashMap<String, Integer> mapWord;
    private static final int THRESHOLD = 10;

    public ComparingLiterary(String fileName) throws IOException {
        String separator = " ";
        textWords = CommonFunctions.loadDictionary(fileName, separator);
        mapWord = new LinkedHashMap<>();
    }

    public String wordFrequency() {
        for (String aWord : textWords) {
            Integer freq = mapWord.get(aWord);
            mapWord.put(aWord.replaceAll("[^a-zA-Z ]", "").toLowerCase(), (freq == null)? 1: ++freq);
        }

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        int maxThreshold = Integer.MAX_VALUE;

        while (idx < THRESHOLD) {
            String str = findFreqWordAfterthreshold(mapWord, maxThreshold);
            sb.append(str);
            maxThreshold = Integer.parseInt(str.substring(0, str.indexOf(":")).trim());
            idx++;
        }
        return sb.toString().trim();
    }

    private String findFreqWordAfterthreshold(LinkedHashMap<String, Integer> mapText, int threshold) {
        int max = 0;
        String wordFreqMax = null;
        for (Map.Entry<String, Integer> entry : mapText.entrySet()) {
            if (entry.getValue() > max && entry.getValue() < threshold) {
                max = entry.getValue();
                wordFreqMax = entry.getKey();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append(": ").append(wordFreqMax).append(", ");
        return sb.toString();
    }
}
