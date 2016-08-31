package InterviewProblems.CrackingCodingInterview;

import org.junit.Assert;
import org.testng.annotations.Test;

public class ModerateTest {

    @Test
    public void numberSwapperTest() {
        int a =5;
        int b =4;

        Moderate m = new Moderate();
        int[] swap = m.numberSwapper(a,b);
        Assert.assertEquals(4, swap[0]);
        Assert.assertEquals(5, swap[1]);
    }

    @Test
    public void wordFrequencyTest() {
        Moderate m = new Moderate();
        String text = "roll tide roll!\n" +
                "Roll Tide Roll!\n" +
                "ROLL TIDE ROLL!\n" +
                "ROll tIDE ROll!\n" +
                " roll  tide  roll! \n" +
                " Roll  Tide  Roll! \n" +
                " ROLL  TIDE  ROLL! \n" +
                "   roll    tide    roll!   \n" +
                "    Roll Tide Roll  !   ";
        String word = "roll";
        Assert.assertEquals(18, m.wordFrequency(text, word));
    }

    @Test
    public void ticTacToeWonTest() {
        Moderate m = new Moderate();
        int[][] multiRow = new int[][]{
                { -1,  0,  0},
                { -1, -1, -1},
                {  1,  0,  0}
        };
        Assert.assertEquals(true, m.ticTacToeWon(multiRow));

        int[][] multiColumn = new int[][]{
                {-1,  1,  0},
                { 0,  1, -1},
                { 1,  1, -1}
        };
        Assert.assertEquals(true, m.ticTacToeWon(multiColumn));

        int[][] multiDiag = new int[][]{
                {-1,  0,  1},
                { 0,  1, -1},
                { 1,  1, -1}
        };
        Assert.assertEquals(true, m.ticTacToeWon(multiDiag));

        int[][] multiNonTTT = new int[][]{
                {-1,  0,  1},
                { 0,  0, -1},
                { 1,  1, -1}
        };
        Assert.assertEquals(false, m.ticTacToeWon(multiNonTTT));
    }

    @Test
    public void factorialZerosTest() {
        Moderate m = new Moderate();
        Assert.assertEquals(6, m.factorialZeros(25));
        Assert.assertEquals(0, m.factorialZeros(4));
    }

    @Test
    public void smallestDifferenceIntArrTest() {
        Moderate m = new Moderate();
        int[] arr1 = new int[] {1, 3, 15, 11, 2};
        int[] arr2 = new int[] {23, 127, 235, 19, 8};
        Assert.assertEquals(3, m.smallestDifferenceIntArr(arr1, arr2));
    }
}
