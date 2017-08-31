package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DynamicProgrammingTest {

    /**
     * 17.1
     */
    @Test
    public void nflScoreCombinationsTest() {
        DynamicProgramming d = new DynamicProgramming();
        int score =12;
        Assert.assertEquals(4, d.nflScoreCombinations(score));
        //7+3+2
        //3+3+3+3
        //2+2+2+2+2+2
        //3+3+2+2

        score =15;
        Assert.assertEquals(5, d.nflScoreCombinations(score));
        //7+2+2+2+2
        //7+3+3+2
        //3+3+3+3+3
        //3+2+2+2+2+2+2
        //3+3+3+2+2+2
    }
}
