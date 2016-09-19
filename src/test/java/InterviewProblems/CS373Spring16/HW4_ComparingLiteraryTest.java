package InterviewProblems.CS373Spring16;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class HW4_ComparingLiteraryTest {

    @Test
    public void frequencyAnalysisTest() throws IOException {
        HW4_ComparingLiterary h = new HW4_ComparingLiterary("Hamlet.txt");
        String s = h.wordFrequency();
        System.out.println(s);
    }
}
