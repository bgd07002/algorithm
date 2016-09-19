package InterviewProblems.UW143Spring16.HW5_Hangman;

import Utility.CommonFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class HangmanPredictor {

    private final String DICTIONARY_FILE = "Dictionary.txt";
    private ArrayList<String> filterDictionary;
    private char[] guessedCharList;
    private int guessedCharIdx;

    public HangmanPredictor() throws IOException {
        filterDictionary = CommonFunctions.loadDictionary(DICTIONARY_FILE, null);
        guessedCharIdx = 0;
        guessedCharList = new char[] {'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'l',
                                      'd', 'c', 'u', 'm', 'f', 'p', 'g', 'w', 'y', 'b',
                                      'v', 'k', 'x', 'j', 'q', 'z'};
    }

    public int numberOfTrials() {
        return guessedCharIdx;
    }

    public boolean smartPredictor(String inputWord) {
        char[] wordGuess = new char[inputWord.length()];
        return predictorHelper(inputWord, wordGuess);
    }

    private boolean checkSuccess(char[] guess) {
        boolean isSuccess = true;
        for (char c : guess)
            isSuccess = isSuccess && (c != '\u0000');

        return isSuccess;
    }

    private boolean predictorHelper(String inputWord, char[] guess) {

        if (guessedCharIdx >= guessedCharList.length)
            return false;

        while (!inputWord.contains(Character.toString(guessedCharList[guessedCharIdx]))) {
            guessedCharIdx++;
        }

        String letter =  Character.toString(guessedCharList[guessedCharIdx]);
        int[] letterLocations = new int[inputWord.length() - inputWord.replace(letter,"").length()];
        for (int i =0; i < letterLocations.length; i++) {
            letterLocations[i] = inputWord.indexOf(letter, ((i==0)? -1 : letterLocations[i-1])+1);
        }

        LinkedList<String> sweepList = new LinkedList<>();
        for (int i =0; i < filterDictionary.size(); i++) {
            if (inputWord.length() != filterDictionary.get(i).length()) {
                sweepList.add(filterDictionary.get(i));
                continue;
            }

            int[] filteredDicEntryLetterLoc = new int[filterDictionary.get(i).length() - filterDictionary.get(i).replace(letter,"").length()];
            if (letterLocations.length != filteredDicEntryLetterLoc.length) {
                sweepList.add(filterDictionary.get(i));
                continue;
            }

            for (int j =0; j < letterLocations.length; j++) {
                filteredDicEntryLetterLoc[j] = filterDictionary.get(i).indexOf(letter, ((j==0)? -1 : letterLocations[j-1])+1);
                if (letterLocations[j] != filteredDicEntryLetterLoc[j]) {
                    sweepList.add(filterDictionary.get(i));
                    continue;
                }
            }
        }

        //Sweep ineligible words from dictionary
        for (String str : sweepList) {
            filterDictionary.remove(str);
        }

        //Place characters into word template
        for (int i : letterLocations) {
            guess[i] = guessedCharList[guessedCharIdx];
        }

        if (checkSuccess(guess) || filterDictionary.size() == 1)
            return true;
        else {
            guessedCharIdx++;
            return predictorHelper(inputWord, guess);
        }
    }
}
