package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.*;

public class SearchingTest {

    /**
     * 12.1
     */
    @Test
    public void firstOccurranceTest() {
        Searching s = new Searching();
        int[] sortedArr = {0,1,2,2,2,3,4,5,5,7,7,8,9,11,11,11,11,11,14,18,21};
        Assert.assertEquals(2, s.firstOccurrence(sortedArr, 2));
        Assert.assertEquals(13, s.firstOccurrence(sortedArr, 11));
        Assert.assertEquals(-1, s.firstOccurrence(sortedArr, 10));
    }

    /**
     * 12.2
     */
    @Test
    public void searchElementEqualtoIndexTest() {
        Searching s = new Searching();
        int[] sortedArr = {-1,0,1,2,3,4,5,5,7,7,8,9,11,11,11,11,11,14,18,21};
        Assert.assertEquals(18, s.searchElementEqualtoIndex(sortedArr));

        sortedArr = new int[]{-1,0,2,2,3,4,5,5,7,7,8,9,11,11,11,11,11,14,19,21};
        Assert.assertEquals(2, s.searchElementEqualtoIndex(sortedArr));

        sortedArr = new int[]{1,2,3,4,5,6,7,8,9,11,12,14,18,21};
        Assert.assertEquals(-1, s.searchElementEqualtoIndex(sortedArr));
    }

    /**
     * 12.3
     * 12.4 Compute Integer Square Root
     * 12.5
     * 12.6
     */
    @Test
    public void integerSquareRootTest() {
        Searching s = new Searching();
        Assert.assertEquals(5, s.integerSquareRoot(24));
        Assert.assertEquals(4, s.integerSquareRoot(19));
        Assert.assertEquals(4, s.integerSquareRoot(20));
        Assert.assertEquals(6, s.integerSquareRoot(36));
    }
}
