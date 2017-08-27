package Algorithms.GreedyAlgorithms;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GreedyAlgorithmTest {

    @Test
    public void activitySelectionTest() {
        GreedyAlgorithm a = new GreedyAlgorithm();
        int start[] =  {1, 3, 0, 5, 8, 5};
        int finish[] =  {2, 4, 6, 7, 9, 9};
        List<Integer> activityList = a.activitySelection(start,finish);
        int[] expectedList = {0,1,3,4};
        Assert.assertArrayEquals(expectedList, activityList.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void optimalTaskAssignmentTest() {
        GreedyAlgorithm a = new GreedyAlgorithm();
        Assert.assertEquals(8, a.optimalTaskAssignment(new int[]{5,2,1,6,4,4}));
    }

    @Test
    public void minimalWaitingTimeTest() {
        GreedyAlgorithm g = new GreedyAlgorithm();
        int actualDelay = g.minimalWaitingTime(new int[]{2,5,1,3});
        Assert.assertEquals(10, actualDelay);
    }
}
