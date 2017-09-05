package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class HashTablesTest {

    /**
     * 13.1
     */
    @Test
    public void permutationPalindromeTest() {
        HashTables h = new HashTables();
        Assert.assertEquals(true, h.permutationPalindrome("edified"));
        Assert.assertEquals(true, h.permutationPalindrome("ediffied"));
        Assert.assertEquals(false, h.permutationPalindrome("sdiffiedt"));
    }

    /**
     * 13.2
     */
    @Test
    public void ISBNCacheTest() {
        HashTables h = new HashTables();
        HashTables.ISBNCache is = h.new ISBNCache();

        is.insert("0-8244-2959-X",22);
        is.insert("0-85131-041-1", 34);
        is.insert("0-943396-04-5", 6);
        is.insert("0-9752298-1-X", 95);

        Assert.assertEquals(6, is.lookup("0-943396-04-5"));
        Assert.assertEquals(95, is.lookup("0-9752298-1-X"));

        is.remove("0-8244-2959-X");
        Assert.assertEquals(-1, is.lookup("0-8244-2959-X"));
    }

    @Test
    public void nearestRepetitionTest() throws IOException {
        HashTables h = new HashTables();
        String s = "All work, and no play; makes for work no fun, and no results.";
        Assert.assertEquals("no", h.nearestRepetition(s));
    }
}
