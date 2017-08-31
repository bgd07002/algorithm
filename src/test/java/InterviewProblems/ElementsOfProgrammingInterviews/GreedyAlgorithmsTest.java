package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by bdundar on 8/29/2017.
 */
public class GreedyAlgorithmsTest {

    /**
     * 18.1
     */
    @Test
    public void optimalTaskAssignmentTest() {
        GreedyAlgorithms a = new GreedyAlgorithms();
        Assert.assertEquals(8, a.optimalTaskAssignment(new int[]{5,2,1,6,4,4}));
    }

    /**
     * 18.2
     */
    @Test
    public void minimalWaitingTimeTest() {
        GreedyAlgorithms g = new GreedyAlgorithms();
        int actualDelay = g.minimalWaitingTime(new int[]{2,5,1,3});
        Assert.assertEquals(10, actualDelay);
    }
}
