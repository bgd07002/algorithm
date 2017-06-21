package InterviewProblems.CS373Spring16.HW4_ComparingLiterary;

import InterviewProblems.CS373Spring16.HW4_ComparingLiterary.ComparingLiterary;
import org.testng.annotations.Test;
import java.io.IOException;

public class ComparingLiteraryTest {

    @Test
    public void frequencyAnalysisTest() throws IOException {
        ComparingLiterary h = new ComparingLiterary("Hamlet.txt");
        String s = h.wordFrequency();
        System.out.println(s);
    }
}
