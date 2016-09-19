package InterviewProblems.UW143Spring16.HW5_Hangman;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HangmanPredictorTest {

    @Test
    public void hangmanPredictor() throws IOException {
        HangmanPredictor h = new HangmanPredictor();
        String challenge = "melancholic";
        Assert.assertEquals(true, h.smartPredictor(challenge));
        Assert.assertEquals(3, h.numberOfTrials());

        challenge = "engendering";
        h = new HangmanPredictor();
        Assert.assertEquals(true, h.smartPredictor(challenge));
        Assert.assertEquals(5, h.numberOfTrials());

        challenge = "sully";
        h = new HangmanPredictor();
        Assert.assertEquals(true, h.smartPredictor(challenge));
        Assert.assertEquals(12, h.numberOfTrials());
    }
}
