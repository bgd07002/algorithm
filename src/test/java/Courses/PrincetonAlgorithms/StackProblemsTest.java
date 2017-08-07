package Courses.PrincetonAlgorithms;

import org.junit.Assert;
import org.testng.annotations.Test;

public class StackProblemsTest {

    @Test
    public void computeArithmeticTest() {
        StackProblems s = new StackProblems();
        int result = s.computeArithmetic("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        Assert.assertEquals(101, result);

        result = s.computeArithmetic("1+((2+3)*(4*5))");
        Assert.assertEquals(101, result);
    }
}
