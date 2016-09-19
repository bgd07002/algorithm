package InterviewProblems.UW143Spring16.HW1_LetterInventory;

/**
 * In this assignment, you will implement a class called LetterInventory that can be used to keep track of an
 inventory of letters of the alphabet. The constructor for the class takes a String and computes how many of
 each letter are in the String. This is the information the object keeps track of (how many a’s, how many b’s,
 etc). It ignores the case of the letters and ignores anything that is not an alphabetic character (e.g., it ignores
 punctuation characters, digits and anything else that is not a letter).
 */

public class LetterInventory {

    private static int ALPHABET_SIZE = 26;
    int[] letterMap = new int[ALPHABET_SIZE];

    /**
     * Constructs an inventory (a count) of the alphabetic letters in the given string, ignoring the case of
     * letters and ignoring any non-alphabetic characters.
     */
    public LetterInventory(String data) {
        for (char c : data.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char ch = Character.toLowerCase(c);
                int charVal = (int)ch- 97;
                letterMap[charVal]++;
            }
        }
    }

    /**
     * Returns a count of how many of this letter are in the inventory. Letter might be lowercase or uppercase
     * (your method shouldn’t care). If a non-alphabetic character is passed, your method should throw an IllegalArgumentException.
     */
    public int get(char letter) {
        if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
            int charVal = (int)Character.toLowerCase(letter)- 97;
            return letterMap[charVal];
        }
        return -1;
    }

    /**
     * Sets the count for the given letter to the given value. Letter might be lowercase or uppercase. If a nonalphabetic
     * character is passed or if value is negative, your method should throw an IllegalArgumentException
     */
    public void set(char letter, int value) {

    }

    /**
     * Returns the sum of all of the counts in this inventory. This operation should be “fast” in that it
     * should store the size rather than having to compute it each time this method is called.
     */
    public int size() {
        int sum = 0;
        for (int i : letterMap)
            sum +=i;

        return sum;
    }

    /**
     * Returns true if this inventory is empty (all counts are 0). This operation should be fast in that it
     * should not need to examine each of the 26 counts when it is called.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns a String representation of the inventory with the letters all in lowercase and in sorted order
     * and surrounded by square brackets. The number of occurrences of each letter should match its count in
     * the inventory. For example, an inventory of 4 a’s, 1 b, 1 l and 1 m would be represented as “[aaaablm]”.
     */
    public String toString() {
        return print(letterMap);
    }

    private String print(int[] letterMapper) {

        StringBuilder sb = new StringBuilder("[");
        for (int i =0; i < letterMapper.length; i++) {
            if (letterMapper[i] > 0) {
                char c = (char) (i + 97);
                for (int j =0; j<letterMapper[i]; j++)
                    sb.append(c);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Constructs and returns a new LetterInventory object that represents the sum of this letter inventory
     * and the other given LetterInventory. The counts for each letter should be added together. The two
     * LetterInventory objects being added together (this and other) should not be changed by this method.
     */
    public LetterInventory add(LetterInventory other) {
        String substr = toString().replace("[","").replace("]","");
        return new LetterInventory(substr+other);
    }

    /**
     * Constructs and returns a new LetterInventory object that represents the result of subtracting the
     * other inventory from this inventory (i.e., subtracting the counts in the other inventory from this
     * object’s counts). If any resulting count would be negative, your method should return null. The two
     * LetterInventory objects being subtracted (this and other) should not be changed by this method.
     */
    public LetterInventory subtract(LetterInventory other) {

        int[] letterMapSubstract = new int[ALPHABET_SIZE];
        for(int i=0; i < ALPHABET_SIZE; i++){
            letterMapSubstract[i] = letterMap[i] - other.get((char) (i+97));
            if (letterMapSubstract[i] < 0)
                letterMapSubstract[i] =0;
        }

        String str = print(letterMapSubstract);
        return new LetterInventory(str);
    }

}
