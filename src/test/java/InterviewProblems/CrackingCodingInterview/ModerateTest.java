package InterviewProblems.CrackingCodingInterview;

import org.junit.Assert;
import org.testng.TestNGAntTask;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

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

    @Test
    public void englishIntTest() {
        Moderate m = new Moderate();
        int n = 1234567817;
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Seventeen";
        Assert.assertEquals(expected, m.englishInt(n));

        n = 1000000;
        expected = "One Million";
        Assert.assertEquals(expected, m.englishInt(n));
    }

    @Test
    public void OperationsWithAdditionTest() {
        Moderate.OperationsWithAddition m = new Moderate().new OperationsWithAddition();
        Assert.assertEquals(14, m.substract(18,4));
        Assert.assertEquals(72, m.multiply(18,4));
        Assert.assertEquals(4, m.divide(18,4));
        Assert.assertEquals(0, m.multiply(4,0));
        Assert.assertEquals(4, m.substract(4,0));

        //Tests with negative tests
        Assert.assertEquals(-72, m.multiply(18,-4));
        Assert.assertEquals(-72, m.multiply(-18,4));
        Assert.assertEquals(72, m.multiply(-18,-4));

        //Division with negative tests
        Assert.assertEquals(-4, m.divide(18,-4));
        Assert.assertEquals(-4, m.divide(-18,4));
        Assert.assertEquals(4, m.divide(-18,-4));
    }

    @Test
    public void livingPeopleTest() {
        Moderate m = new Moderate();
        ArrayList<int[]> peopleAge = new ArrayList<>();

        peopleAge.add(new int[]{1957, 2004});
        peopleAge.add(new int[]{1971, 1989, 2000});
        peopleAge.add(new int[]{1980, 2016});
        peopleAge.add(new int[]{1942, 1998});
        peopleAge.add(new int[]{1926, 1966});
        peopleAge.add(new int[]{1905, 1961});
        peopleAge.add(new int[]{1985, 2016});
        peopleAge.add(new int[]{1963, 2006});
        peopleAge.add(new int[]{1975, 2017});
        peopleAge.add(new int[]{1959, 2010});
        peopleAge.add(new int[]{1971, 1989});

        int mostLivedYear = m.livingPeople(peopleAge);
        Assert.assertEquals(1977, mostLivedYear);
    }

    @Test
    public void xmlEncodingTest() {
        Moderate m = new Moderate();
        String xml = "<family lastName=\"McDowell\" state=\"CA\">\n" +
                        "<person firstName=\"Gayle\">Some Message<person/>\n" +
                     "<family/>";

        System.out.println("Encoding: " + m.xmlEncoding(xml));
        Assert.assertEquals("1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0", m.xmlEncoding(xml));
    }

    @Test
    public void subSortTest() {
        Moderate m = new Moderate();
        int[] input = new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] expected = new int[] {3,9};
        Assert.assertArrayEquals(expected, m.subSort(input));
    }
}
