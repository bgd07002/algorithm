package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArraysTest {

    /**
     * 6.2 and 6.3
     */
    @Test
    public void bigIntegerTest() {
        Arrays a = new Arrays();
        Arrays.BigInteger b = a.new BigInteger();

        ArrayList<Integer> a1 = new ArrayList<>(java.util.Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> a2 = new ArrayList<>(java.util.Arrays.asList(5,6,7));
        ArrayList<Integer> sum = b.add(a1,a2);
        Assert.assertArrayEquals(new int[] {1,2,9,1,2}, sum.stream().mapToInt(i->i).toArray());

        a1 = new ArrayList<>(java.util.Arrays.asList(-1,2,3,4,5));
        a2 = new ArrayList<>(java.util.Arrays.asList(-7,8,9));
        sum = b.add(a1,a2);
        Assert.assertArrayEquals(new int[] {-1,3,1,3,4}, sum.stream().mapToInt(i->i).toArray());
    }

    /**
     * 6.5
     */
    @Test
    public void removeDuplicatesFromSortedArrayTest() {
        Arrays a = new Arrays();
        int[] sortedArray = {1,1,1,2,2,3,3};
        a.removeDuplicatesFromSortedArray(sortedArray);
        Assert.assertArrayEquals(new int[]{1,2,3,0,0,0,0}, sortedArray);

        int[] sortedArray2 = {1,1,1,1,1,1,1};
        a.removeDuplicatesFromSortedArray(sortedArray2);
        Assert.assertArrayEquals(new int[]{1,0,0,0,0,0,0}, sortedArray2);

        int[] sortedArray3 = {1,2,3,4,5,6,7};
        a.removeDuplicatesFromSortedArray(sortedArray3);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7}, sortedArray3);
    }

    @Test
    public void maxDifferenceArrayTest() {
        Arrays a = new Arrays();
        int[] numArr = new int[] {2,-10, 3, -7, 23, 7, 56, 43, -9};
        Assert.assertEquals(66, a.maxDifferenceArray(numArr));
    }


    @Test
    public void checkSudokuTest() {
        Arrays a = new Arrays();
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

    /**
     * 6.17
     */
    @Test
    public void spiralOrderingTest() {
        Arrays a = new Arrays();
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
                {13,14,15,16}
        };
        int[] result = a.spiralOrdering(arr);
        Assert.assertArrayEquals(new int[]{1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10}, result);

        int[][] arr2= new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        result = a.spiralOrdering(arr2);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13}, result);
    }


    /**
     * 6.19
     */
    @Test
    public void computePascalTriangleTest() {
        Arrays a = new Arrays();
        List<int[]> pascalList = a.computePascalTriangle(5);
        List<int[]> expectedList = new ArrayList<>();
        expectedList.add(new int[]{1});
        expectedList.add(new int[]{1,1});
        expectedList.add(new int[]{1,2,1});
        expectedList.add(new int[]{1,3,3,1});
        expectedList.add(new int[]{1,4,6,4,1});
        Assert.assertArrayEquals(expectedList.get(0), pascalList.get(0));
        Assert.assertArrayEquals(expectedList.get(1), pascalList.get(1));
        Assert.assertArrayEquals(expectedList.get(2), pascalList.get(2));
        Assert.assertArrayEquals(expectedList.get(3), pascalList.get(3));
        Assert.assertArrayEquals(expectedList.get(4), pascalList.get(4));
    }

}
