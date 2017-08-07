package Algorithms.DynamicProgramming;

import org.junit.Assert;
import org.testng.annotations.Test;

public class FibonacciTest {

    @Test
    public void longestCommonSubSeqTest() {
        Fibonacci f = new Fibonacci();
        Assert.assertEquals(0, f.computeFibonnaci(0));
        Assert.assertEquals(1, f.computeFibonnaci(1));
        Assert.assertEquals(8, f.computeFibonnaci(6));
    }
}
