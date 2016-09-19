package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class HashTablesTest {

    @Test
    public void nearestRepetitionTest() throws IOException {
        HashTables h = new HashTables();
        String s = "All work, and no play; makes for work no fun, and no results.";
        Assert.assertEquals("no", h.nearestRepetition(s));
    }
}
