package Algorithms.DynamicProgramming;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DynamicProgrammingTest {

    @Test
    public void longestCommonSubSeqTest() {
    LongestCommonSubsequence s = new LongestCommonSubsequence();
    String str1 = "ABCB";
    String str2 = "BDCAB";

    String lcs = s.longestCommonSubSeq(str1, str2);
    Assert.assertEquals("BCB", lcs);

    str1 = "AGGTAB";
    str2 = "GXTXAYB";
    lcs = s.longestCommonSubSeq(str1, str2);
    Assert.assertEquals("GTAB", lcs);

    /*
    TestListenerAdapter tla = new TestListenerAdapter();
    TestNG testng = new TestNG();
    testng.
    testng.setTestClasses(new Class[] { Run2.class });
    testng.addListener(tla);
    testng.run();
    */
    }
}
