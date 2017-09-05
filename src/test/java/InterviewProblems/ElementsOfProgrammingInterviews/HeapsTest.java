package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class HeapsTest {

    /**
     * 11.1
     */
    @Test
    public void mergeSortedArraysTest() {
        int[] a = {3,5,7};
        int[] b = {0,6};
        int[] c = {0,6,28};

        List<int[]> sortedArrList = java.util.Arrays.asList(a,b,c);
        Heaps h = new Heaps();
        List<Integer> mergedList = h.mergeSortedArrays(sortedArrList);
        int[] result = mergedList.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(new int[]{0,0,3,5,6,6,7,28}, result);
    }

    /**
     * 11.2
     */
    @Test
    public void sortIncreasingDecreasingArrayTest() {
        Heaps h = new Heaps();
        int[] input = {57,131,152,185,493,325,294,221,339,401,418,452,442,190};
        Assert.assertArrayEquals(new int[] {57,131,152,185,190,221,294,325,339,401,418,442,452,493}, h.sortIncreasingDecreasingArray(input));

        int[] input2 = {1,2,3,4,5,6,7};
        Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,7}, h.sortIncreasingDecreasingArray(input2));
    }

    /**
     * 11.3 Almost sorted array
     */
    @Test
    public void sortAlmostSortedArrayTest() {
        Heaps h = new Heaps();
        int[] almostSortedArray = {0,2,4,6,5,7,9,11,10,14,17,19,15,22,45,30};
        h.sortAlmostSortedArray(almostSortedArray);
        Assert.assertArrayEquals(new int[]{0,2,4,5,6,7,9,10,11,14,15,17,19,22,30,45}, almostSortedArray);
    }

}
