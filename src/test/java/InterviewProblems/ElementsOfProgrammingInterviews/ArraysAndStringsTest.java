package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndStringsTest {

    @Test
    public void bigIntegerTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        ArraysAndStrings.BigInteger b = a.new BigInteger();

        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(5,6,7));
        ArrayList<Integer> sum = b.add(a1,a2);
        Assert.assertArrayEquals(new int[] {1,2,9,1,2}, sum.stream().mapToInt(i->i).toArray());

        a1 = new ArrayList<>(Arrays.asList(-1,2,3,4,5));
        a2 = new ArrayList<>(Arrays.asList(-7,8,9));
        sum = b.add(a1,a2);
        Assert.assertArrayEquals(new int[] {-1,3,1,3,4}, sum.stream().mapToInt(i->i).toArray());
    }

    @Test
    public void maxDifferenceArrayTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        int[] numArr = new int[] {2,-10, 3, -7, 23, 7, 56, 43, -9};
        Assert.assertEquals(66, a.maxDifferenceArray(numArr));
    }

    /**
     * 6.18 Run length encoding
     */
    @Test
    public void runLengthEncodingDecodingTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        Assert.assertEquals("4a1b3c2a", a.runLengthEncoding("aaaabcccaa"));
        Assert.assertEquals("1a", a.runLengthEncoding("a"));
        Assert.assertEquals("5a", a.runLengthEncoding("aaaaa"));

        Assert.assertEquals("aaaabbccc", a.runLengthDecoding("4a2b3c"));
        Assert.assertEquals("bbbbbbbbbbc", a.runLengthDecoding("10b1c"));
        Assert.assertEquals("d", a.runLengthDecoding("1d"));
    }

    /**
     * 6.19 Reverse All Words
     */
    @Test
    public void reverseAllWordsTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        Assert.assertEquals("Bob Likes Alice", a.reverseWords("Alice Likes Bob"));
        Assert.assertEquals("d c b a", a.reverseWords("a b c d"));
        Assert.assertEquals("abcd", a.reverseWords("abcd"));
    }

    /**
     * 6.20 Find first substring
     */
    @Test
    public void findFirstOccurenceStringTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        Assert.assertEquals(9, a.findFirstOccurenceString("the", "Istanbul the pazar the pijama the"));
        Assert.assertEquals(-1, a.findFirstOccurenceString("the", "Istanbul t th pazar pijama "));
        Assert.assertEquals(0, a.findFirstOccurenceString("the", "the "));
    }

    /**
     * 6.21 Replace and remove
     */
    @Test
    public void replaceAndRemoveTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        char[] s = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'B', 'a', 'h', 'a', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        Assert.assertEquals("Hello ddhdd", a.replaceAndRemove(s));

        s = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'B', 'a', 'h', 'a', 'B','\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        Assert.assertEquals("Hello ddhdd", a.replaceAndRemove(s));

        s = new char[]{'H', 'e', 'l', 'l', 'o'};
        Assert.assertEquals("Hello", a.replaceAndRemove(s));
    }

    @Test
    public void phoneNumberWordsTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        ArrayList<StringBuilder> list = a.phoneNumberWords(new int[]{1,3,4});

        Assert.assertEquals("DG", list.get(0).toString());
        Assert.assertEquals("DH", list.get(1).toString());
        Assert.assertEquals("DI", list.get(2).toString());
        Assert.assertEquals("EG", list.get(3).toString());
        Assert.assertEquals("EH", list.get(4).toString());
        Assert.assertEquals("EI", list.get(5).toString());
        Assert.assertEquals("FG", list.get(6).toString());
        Assert.assertEquals("FH", list.get(7).toString());
        Assert.assertEquals("FI", list.get(8).toString());
    }

    @Test
    public void testPalindromicityTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        String s1 = "A man, a plan, a canal, Panama.";
        String s2 = "Able was I, ere I saw Elba!";
        String s3 = "Ray a Ray";

        Assert.assertEquals(true, a.testPalindromicity(s1));
        Assert.assertEquals(true, a.testPalindromicity(s2));
        Assert.assertEquals(false, a.testPalindromicity(s3));
    }

    @Test
    public void checkSudokuTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        int[][] sudokuBoard = new int[][]{
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };
        Assert.assertEquals(true, a.checkSudoku(sudokuBoard));
        sudokuBoard[1][2]=6;
        Assert.assertEquals(false, a.checkSudoku(sudokuBoard));
        sudokuBoard[1][2]=2;
        sudokuBoard[2][2]=6;
        Assert.assertEquals(false, a.checkSudoku(sudokuBoard));

        sudokuBoard = new int[][]{
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        Assert.assertEquals(true, a.checkSudoku(sudokuBoard));

    }
}
