package InterviewProblems.CrackingCodingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

public class SortingAndSearchingTest {

    /**
     * 10.1
     */
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

    /**
     * 10.2
     */
    @Test
    public void groupAnagramsTest() {
        SortingAndSearching s = new SortingAndSearching();
        String[] inputStrs = new String[]{"hello", "abaci", "hakkinen", "ciaba", "raikonen", "olleh"};

        String[] groupAnag = s.groupAnagrams(inputStrs);
        String[] expectedArr = new String[] {"abaci", "ciaba", "hakkinen", "hello", "olleh", "raikonen"};

        for (int i =0; i < expectedArr.length; i++) {
            Assert.assertEquals(expectedArr[i], groupAnag[i]);
        }
    }

    /**
     * 10.3
     */
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

        searchRes = s.searchInRotatedArray(14,inpArr);
        Assert.assertEquals(11, searchRes);

        searchRes = s.searchInRotatedArray(7,inpArr);
        Assert.assertEquals(9, searchRes);

        searchRes = s.searchInRotatedArray(12,inpArr);
        Assert.assertEquals(-1, searchRes);

        searchRes = s.searchInRotatedArray(17,inpArr);
        Assert.assertEquals(-1, searchRes);
    }

    /**
     * 10.4
     */
    @Test
    public void searchIdxInSortedArrayTest() {
        SortingAndSearching s = new SortingAndSearching();
        int[] inpArr = {1,2,2,3,4,5,7,10,11,11,14,17,19,20,20, -1, -1, -1, -1};

        int serachIdx = s.searchIdxSortedArray(1, inpArr);
        Assert.assertEquals(0, serachIdx);

        serachIdx = s.searchIdxSortedArray(20, inpArr);
        Assert.assertEquals(13, serachIdx);

        serachIdx = s.searchIdxSortedArray(4, inpArr);
        Assert.assertEquals(4, serachIdx);

        serachIdx = s.searchIdxSortedArray(18, inpArr);
        Assert.assertEquals(-1, serachIdx);
    }

    /**
     * 10.5
     */
    @Test
    public void sparseSearchTest() {
        SortingAndSearching s = new SortingAndSearching();
        String[] inputArr  = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        Assert.assertEquals(4, s.sparseSearch("ball", inputArr));
        Assert.assertEquals(0, s.sparseSearch("at", inputArr));
        Assert.assertEquals(10, s.sparseSearch("dad", inputArr));
        Assert.assertEquals(-1, s.sparseSearch("son", inputArr));
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

    @Test
    public void rankOfNumberTest() {
        SortingAndSearching s = new SortingAndSearching();
        Integer[] inputStream = new Integer[]{5, 1, 4, 4, 5, 9, 7, 13, 3};

        Assert.assertEquals(0, s.rankOfNumber(inputStream, 1));
        Assert.assertEquals(1, s.rankOfNumber(inputStream, 3));
        Assert.assertEquals(4, s.rankOfNumber(inputStream, 5));
    }
}
