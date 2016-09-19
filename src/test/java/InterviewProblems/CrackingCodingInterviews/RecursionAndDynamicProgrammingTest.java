package InterviewProblems.CrackingCodingInterviews;

import InterviewProblems.CrackingCodingInterviews.RecursionAndDynamicProgramming;
import org.junit.Assert;
import org.testng.annotations.Test;

public class RecursionAndDynamicProgrammingTest {

    @Test
    public void tripleStepsTest() {
        RecursionAndDynamicProgramming r = new RecursionAndDynamicProgramming();
        int tripleStepsWay = r.tripleSteps(10);
        Assert.assertEquals(14, tripleStepsWay);

        tripleStepsWay = r.tripleSteps(100);
        Assert.assertEquals(884, tripleStepsWay);
    }

}
