package AdvancedAlgorithms.DynamicProgramming;

public class LongestCommonSubsequence {

    /**
     * Solution with Dynamic Programming
     */
    public String longestCommonSubSeq(String seq1, String seq2) {
        char[] seq1Char = seq1.toCharArray();
        char[] seq2Char = seq2.toCharArray();
        int[][] dynProg = new int[seq1.length()+1][seq2.length()+1];

        for (int i =0; i < dynProg.length; i++) {
            for (int j =0; j < dynProg[i].length; j++) {
                if (i==0)
                    dynProg[0][j]=0;

                if (j==0)
                    dynProg[i][0]=0;

                if (i > 0 && j > 0) {
                    if (seq1Char[i-1] == seq2Char[j-1])
                        dynProg[i][j] = 1 + dynProg[i-1][j-1];
                    else
                        dynProg[i][j] = Math.max(dynProg[i][j-1], dynProg[i-1][j]);
                }
            }
        }

        //Now we find the LCS string
        int i = seq1.length();
        int j = seq2.length();
        StringBuilder lcs = new StringBuilder();
        while(dynProg[i][j] != 0) {
            if (dynProg[i][j-1] == dynProg[i][j])
                j--;
            else if (dynProg[i][j-1] < dynProg[i][j] && seq1Char[i-1]==seq2Char[j-1]) {
                lcs.append(seq1Char[i-1]);
                i--;
                j--;
            }
        }
        return lcs.reverse().toString();
    }
}
