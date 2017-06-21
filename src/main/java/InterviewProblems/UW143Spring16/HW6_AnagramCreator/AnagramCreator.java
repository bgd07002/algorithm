package InterviewProblems.UW143Spring16.HW6_AnagramCreator;

import Utility.CommonFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AnagramCreator {

    private final String DICTIONARY_FILE = "Dictionary.txt";
    private ArrayList<String> dictionary;

    public AnagramCreator() throws IOException {
        dictionary = CommonFunctions.loadDictionary(DICTIONARY_FILE, null);
    }

    public ArrayList<ArrayList<String>> generateAnagramSet(String phase) {
        //Raw phase will consists of characters without spaces
        //Example: {"barbara bush"} -> {"aaabbbhrrsu"}
        String rawPhase = arrangePhase(phase);

        //This will create all words in the dictionary that is a sub-anagram
        //Example: {"aaabbbhrrsu"} -> {abash, aura, bar, barb, brush, bus, hub, rub, shrub, sub}
        LinkedList<String> reducedWordSet = createAnagramMultiwords(rawPhase);

        //This will create max set of anagrams
        //[abash, bar, rub]
        //[abash, rub, bar]
        //[bar, abash, rub]
        //[bar, rub, abash]
        //[rub, abash, bar]
        //[rub, bar, abash]

        //Convert string to list of chars
        List<Character> listRawPhase = new LinkedList<>();
        rawPhase.chars().forEach(e -> listRawPhase.add((char) e));
        ArrayList<ArrayList<String>> anagramList = new ArrayList<>();
        ArrayList<ArrayList<String>>  allAnagrams = generateMaxAnagramCoreSet(anagramList, reducedWordSet, listRawPhase);

        //Now find maximum anagrams
        return allAnagrams;
    }

    private ArrayList<ArrayList<String>> generateMaxAnagramCoreSet(ArrayList<ArrayList<String>> anagramList,
                                                                   LinkedList<String> reducedWordSet,
                                                                   List<Character> listRawPhase) {

        LinkedList<String> filteredReducedWordSet = new LinkedList<>();

        for (String aWord : reducedWordSet) {
            if (listRawPhase.size() < aWord.length())
                continue;

            //Convert string to list of chars
            List<Character> aWordChars = new LinkedList<>();
            aWord.chars().forEach(e -> aWordChars.add((char) e));

            //Remove the aWord characters from rawPhase
            char[] wordArr = aWord.toCharArray();
            boolean isWordExist = true;
            for (char c : wordArr) {
                if (!listRawPhase.contains(c)) {
                    isWordExist = false;
                    break;
                } else
                    listRawPhase.remove(new Character(c));
            }

            if (isWordExist)

            //Now search words from reduceWordSet
            generateMaxAnagramCoreSet(anagramList, filteredReducedWordSet, listRawPhase);
        }
        return null;
    }

    private String arrangePhase(String phase) {
        phase = phase.replace(" ","");
        char[] phaseArr = phase.toCharArray();
        Arrays.sort(phaseArr);
        return new String(phaseArr);
    }

    private LinkedList<String> createAnagramMultiwords(String rawPhase) {
        LinkedList<String> anagramWords = new LinkedList<>();

        for (String word : dictionary) {
            if (word.length() > rawPhase.length())
                continue;

            List<Character> listRawPhase = new LinkedList<>();
            rawPhase.chars().forEach(e -> listRawPhase.add((char) e));

            char[] wordArr = word.toCharArray();
            boolean isWordExist = true;
            for (char c : wordArr) {
                if (!listRawPhase.contains(c)) {
                    isWordExist = false;
                    break;
                } else
                    listRawPhase.remove(new Character(c));
            }

            if (isWordExist)
                anagramWords.add(word);
        }
        return anagramWords;
    }
}
