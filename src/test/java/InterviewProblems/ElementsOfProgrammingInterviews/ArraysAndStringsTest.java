package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ArraysAndStringsTest {

    @Test
    public void replaceAndRemoveTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        char[] s = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'B', 'a', 'h', 'a', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        Assert.assertEquals("Hello ddhdd", a.replaceAndRemove(s));

        s = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'B', 'a', 'h', 'a', 'B','\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        Assert.assertEquals("Hello ddhdd", a.replaceAndRemove(s));

        s = new char[]{'H', 'e', 'l', 'l', 'o'};
        Assert.assertEquals("Hello", a.replaceAndRemove(s));
    }

    @Test
    public void phoneNumberWordsTest() {
        ArraysAndStrings a = new ArraysAndStrings();
        ArrayList<StringBuilder> list = a.phoneNumberWords(new int[]{1,3,4});

        Assert.assertEquals("DG", list.get(0).toString());
        Assert.assertEquals("DH", list.get(1).toString());
        Assert.assertEquals("DI", list.get(2).toString());
        Assert.assertEquals("EG", list.get(3).toString());
        Assert.assertEquals("EH", list.get(4).toString());
        Assert.assertEquals("EI", list.get(5).toString());
        Assert.assertEquals("FG", list.get(6).toString());
        Assert.assertEquals("FH", list.get(7).toString());
        Assert.assertEquals("FI", list.get(8).toString());
    }
}
