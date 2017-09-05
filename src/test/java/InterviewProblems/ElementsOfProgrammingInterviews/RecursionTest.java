package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class RecursionTest {

    /**
     * 16.3 Generate all permutations
     */
    @Test
    public void generateAllPermutationsTest() {
        Recursion r = new Recursion();
        int[] arr = {2,3,5,7};
        ArrayList<ArrayList<Integer>> permutationList = r.generateAllPermutations(arr);
        Assert.assertArrayEquals(new int[]{7,5,3,2}, permutationList.get(0).stream().mapToInt(i->i).toArray());
        Assert.assertArrayEquals(new int[]{7,5,2,3}, permutationList.get(1).stream().mapToInt(i->i).toArray());
        Assert.assertArrayEquals(new int[]{2,3,5,7}, permutationList.get(23).stream().mapToInt(i->i).toArray());
    }

    /**
     * 16.4 Generate all power set
     */

    /**
     * 16.9
     */
    @Test
    public void isSudokuValidTest() {
        Recursion r = new Recursion();

        int[][] sudoku = {
                {8,6,1,7,9,4,3,5,2},
                {3,5,2,1,6,8,7,4,9},
                {4,9,7,2,5,3,1,8,6},
                {2,1,8,9,7,5,6,3,4},
                {6,7,5,3,4,1,9,2,8},
                {9,3,4,6,8,2,5,1,7},
                {5,2,6,8,1,9,4,7,3},
                {7,4,3,5,2,6,8,9,1},
                {1,8,9,4,3,7,2,6,5}
        };
        Assert.assertEquals(true, r.isSudokuValid(sudoku));

        //Row violating
        sudoku[6][2]=9;
        Assert.assertEquals(false, r.isSudokuValid(sudoku));
        sudoku[6][2]=6;

        //Column violating
        sudoku[2][6]=4;
        Assert.assertEquals(false, r.isSudokuValid(sudoku));
        sudoku[2][6]=1;

        sudoku[2][6]=0;
        Assert.assertEquals(true, r.isSudokuValid(sudoku));
    }

}
