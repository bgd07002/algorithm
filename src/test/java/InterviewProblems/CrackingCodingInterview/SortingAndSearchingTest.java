package InterviewProblems.CrackingCodingInterview;

import org.junit.Assert;
import org.testng.annotations.Test;

public class SortingAndSearchingTest {

    @Test
    public void sortedMergeTest() {
        SortingAndSearching<String> s = new SortingAndSearching<>();
        String[] a = {"a","c","e","g","i","k",null,null,null,null,null};
        String[] b = {"b","d","f","h"};

        s.sortedMerge(a,b);
        Assert.assertEquals("b", a[1]);
        Assert.assertEquals("c", a[2]);
        Assert.assertEquals("d", a[3]);
        Assert.assertEquals("e", a[4]);
    }

    @Test
    public void searchInRotatedArrayTest() {
        SortingAndSearching s = new SortingAndSearching();
        int[] inpArr = {15,16,19,20,25,1,3,4,5,7,10,14};

        int searchRes = s.searchInRotatedArray(5,inpArr);
        Assert.assertEquals(8, searchRes);

        searchRes = s.searchInRotatedArray(15,inpArr);
        Assert.assertEquals(0, searchRes);

        searchRes = s.searchInRotatedArray(1,inpArr);
        Assert.assertEquals(5, searchRes);

        searchRes = s.searchInRotatedArray(12,inpArr);
        Assert.assertEquals(-1, searchRes);

        searchRes = s.searchInRotatedArray(17,inpArr);
        Assert.assertEquals(-1, searchRes);
    }

    @Test
    public void sortedMatrixSearchTest() {
        SortingAndSearching s = new SortingAndSearching();
        int[][] multi = new int[][]{
                { 1, 2, 3,  4},
                { 3, 4, 7,  8 },
                { 4, 5, 8,  10 },
                { 7, 9, 11, 12 }
        };

        boolean isFound = s.sortedMatrixSearch(11, multi);
        Assert.assertEquals(true, isFound);

        isFound = s.sortedMatrixSearch(1, multi);
        Assert.assertEquals(true, isFound);

        isFound = s.sortedMatrixSearch(6, multi);
        Assert.assertEquals(false, isFound);
    }
}
