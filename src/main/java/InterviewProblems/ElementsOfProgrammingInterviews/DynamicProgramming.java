package InterviewProblems.ElementsOfProgrammingInterviews;

public class DynamicProgramming {

    /**
     * 17.1 NFL score combinaations: Safety->2, Field goal -> 3, Touch down ->7.
     * Write a program that take a final score and return the number of combinations that result in final score
     */
    public int nflScoreCombinations(int score) {
        int firstDenom = 7;
        return nflScoreCombinationsHelper(score, firstDenom);
    }

    private int nflScoreCombinationsHelper(int score, int denom) {
        int next_denom = 0;

        switch (denom) {
            case 7:
                next_denom = 3;
                break;
            case 3:
                next_denom = 2;
                break;
            case 2:
                return ((score&1) == 0)? 1: 0;
        }
        int ways = 0;
        for (int i = 0; i * denom <= score; i++) {
            ways += nflScoreCombinationsHelper(score - i * denom, next_denom);
        }
        return ways;
    }

    /**
     * 17.2 Correct misspelled string by editing word. In order words, compute the distance between two words.
     * Allowed operations are "insertion", "deletion", and "substitution"
     */
    public void computeLevenshteinDistance(String word1, String word2) {

    }
}
