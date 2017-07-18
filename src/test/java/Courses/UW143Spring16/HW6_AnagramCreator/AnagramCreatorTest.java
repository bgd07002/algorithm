package Courses.UW143Spring16.HW6_AnagramCreator;

import org.testng.annotations.Test;
import java.io.IOException;

public class AnagramCreatorTest {

    @Test
    public void anagramCreatorTest() throws IOException {
        AnagramCreator a = new AnagramCreator();
        a.generateAnagramSet("barbara bush");
    }
}
