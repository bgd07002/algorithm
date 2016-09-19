package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

public class StacksAndQueuesTest {

    @Test
    public void reversePolishExpressionTest() {
        StacksAndQueues s = new StacksAndQueues();
        String exp = "3,4,*,1,2,+,+";
        Assert.assertEquals(15, s.reversePolishExpression(exp));

        exp = "1,1,+,-2,*";
        Assert.assertEquals(-4, s.reversePolishExpression(exp));

        exp = "4,6,/,2,/";
        Assert.assertEquals(0, s.reversePolishExpression(exp));
    }
}
