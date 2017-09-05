package InterviewProblems.ElementsOfProgrammingInterviews;

import DataStructures.Maps.IMap;

import java.security.InvalidParameterException;
import java.util.*;

public class HashTables {

    /**
     * 13.1 Test for palindromic permutation. Write a program to test whether a string can be permuted
     * to form a palindrome. Example: "edified" -> deified
     */
    public boolean permutationPalindrome(String str) {
        int[] charArr =  new int[256];

        //Add character values into integer array of length 256
        for (char c : str.toCharArray()) {
            charArr[(int)c]++;
        }

        //Pass the integer array for odd values
        int oddValues = 0;
        for (int i: charArr) {
            oddValues += ((i&1) == 1)? 1:0;
        }

        return oddValues <= 1;
    }

    /**
     * 13.2 Anonymous letter
     * 13.3 Implement 10 digit ISBN Cache. First 9 chars are digits and 10th character is sum
     * mod 11 with 10th number as 'X'. Use LRU as cache eviction.
     */
    public class ISBNCache {

        Map<String,Integer> lruCache;
        private static final int ISBN_LENGTH = 10;

        public ISBNCache() {
            lruCache = new LinkedHashMap<>();
        }

        public int lookup(String isbn) {
            return (lruCache.containsKey(isbn))? lruCache.get(isbn): -1;
        }

        public void insert(String isbn, int price) {
            if (!isISBNValid(isbn))
                throw new InvalidParameterException();

            if (lruCache.containsKey(isbn))
                lruCache.remove(isbn);

            lruCache.put(isbn, price);

        }

        public void remove(String isbn) {
            if (lruCache.containsKey(isbn))
                lruCache.remove(isbn);
        }

        private boolean isISBNValid(String isbn) {
            if (!isbn.matches("^[0-9X-]+$"))
                return false;

            isbn = isbn.replace("-","");

            if (isbn.length() != ISBN_LENGTH)
                return false;

            char[] isbnArr = isbn.toCharArray();
            int sum =0;
            for (int i=0; i<isbnArr.length-1; i++)
                sum += (int) isbnArr[i] -48;

            if (sum % 11 == 10)
                return (isbnArr[isbnArr.length-1] == 'X')? true: false;
            else
                return (isbnArr[isbnArr.length-1] == (char)(sum%11+48))? true: false;
        }
    }

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


