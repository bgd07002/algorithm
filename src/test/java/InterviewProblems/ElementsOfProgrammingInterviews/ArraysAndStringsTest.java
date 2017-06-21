package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ArraysAndStringsTest {

    @Test
    public void maxDifferenceArrayTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        int[] numArr = new int[] {2,-10, 3, -7, 23, 7, 56, 43, -9};
        Assert.assertEquals(66, a.maxDifferenceArray(numArr));
    }

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
