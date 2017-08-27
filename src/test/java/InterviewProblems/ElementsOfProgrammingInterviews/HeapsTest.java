package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class HeapsTest {

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

}
