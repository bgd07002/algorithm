package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SortingTest {

    /**
     * 14.1
     */
    @Test
    public void intersectionOfTwoSortedArraysTest() {
        int[] arr1 = {2,3,3,5,5,6,7,7,8,12};
        int[] arr2 = {5,5,6,8,8,9,10,10};
        Sorting s = new Sorting();
        List<Integer> intersectionList = s.intersectionOfTwoSortedArrays(arr1, arr2);
        int[] result = intersectionList.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(new int[]{5,6,8}, result);

        int[] arr3 = {2,3,3,5,5,6,7,7,8,12};
        int[] arr4 = {13,14,14, 15, 17,17,19};
        intersectionList = s.intersectionOfTwoSortedArrays(arr3, arr4);
        int[] result2 = intersectionList.stream().mapToInt(i -> i).toArray();
        Assert.assertArrayEquals(new int[]{}, result2);
    }

    /**
     * 14.2 duplicate
     * 14.3
     */
    @Test
    public void removeFirstNameDuplicatesTest() {
        List<String[]> nameList = new ArrayList<>();
        nameList.add(new String[]{"Ian","Botham"});
        nameList.add(new String[]{"David","Gower"});
        nameList.add(new String[]{"Ian","Bell"});
        nameList.add(new String[]{"Ian","Chappel"});
        Sorting s = new Sorting();

        List<String[]> expectedResult = new ArrayList();
        expectedResult.add(new String[]{"David","Gower"});
        expectedResult.add(new String[]{"Ian","Chappel"});

        List<String[]> result = s.removeFirstNameDuplicates(nameList);
        Assert.assertEquals(expectedResult.get(0)[0], result.get(0)[0]);
        Assert.assertEquals(expectedResult.get(0)[1], result.get(0)[1]);

        Assert.assertEquals(expectedResult.get(1)[0], result.get(1)[0]);
        Assert.assertEquals(expectedResult.get(1)[1], result.get(1)[1]);
    }
}
