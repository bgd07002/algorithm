package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

public class StacksAndQueuesTest {

    /**
     * 9.2
     */
    @Test
    public void reversePolishExpressionTest() {
        StacksAndQueues s = new StacksAndQueues();
        String exp = "3,4,*,1,2,+,+";
        Assert.assertEquals(15, s.reversePolishExpression(exp));

        exp = "1,1,+,-2,*";
        Assert.assertEquals(-4, s.reversePolishExpression(exp));

        exp = "4,6,/,-25,+";
        Assert.assertEquals(-24, s.reversePolishExpression(exp));
    }

    /**
     * 9.3
     */
    @Test
    public void paranthesisWellFormationCheckTest() {
        StacksAndQueues s = new StacksAndQueues();
        Assert.assertEquals(true, s.paranthesisWellFormationCheck("([]){()}"));
        Assert.assertEquals(true, s.paranthesisWellFormationCheck("[()[]{()()}]"));

        Assert.assertEquals(false, s.paranthesisWellFormationCheck("{]"));
        Assert.assertEquals(false, s.paranthesisWellFormationCheck("[()[]{()()"));
    }
}
