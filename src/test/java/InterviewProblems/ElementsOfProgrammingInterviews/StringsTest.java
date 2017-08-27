package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class StringsTest {

    /**
     * 6.18 Run length encoding
     */
    @Test
    public void runLengthEncodingDecodingTest() {
        Strings a = new Strings();
        Assert.assertEquals("4a1b3c2a", a.runLengthEncoding("aaaabcccaa"));
        Assert.assertEquals("1a", a.runLengthEncoding("a"));
        Assert.assertEquals("5a", a.runLengthEncoding("aaaaa"));

        Assert.assertEquals("aaaabbccc", a.runLengthDecoding("4a2b3c"));
        Assert.assertEquals("bbbbbbbbbbc", a.runLengthDecoding("10b1c"));
        Assert.assertEquals("d", a.runLengthDecoding("1d"));
    }

    /**
     * 6.19 Reverse All Words
     */
    @Test
    public void reverseAllWordsTest() {
        Strings a = new Strings();
        Assert.assertEquals("Bob Likes Alice", a.reverseWords("Alice Likes Bob"));
        Assert.assertEquals("d c b a", a.reverseWords("a b c d"));
        Assert.assertEquals("abcd", a.reverseWords("abcd"));
    }

    /**
     * 6.20 Find first substring
     */
    @Test
    public void findFirstOccurenceStringTest() {
        Strings a = new Strings();
        Assert.assertEquals(9, a.findFirstOccurenceString("the", "Istanbul the pazar the pijama the"));
        Assert.assertEquals(-1, a.findFirstOccurenceString("the", "Istanbul t th pazar pijama "));
        Assert.assertEquals(0, a.findFirstOccurenceString("the", "the "));
    }

    /**
     * 6.21 Replace and remove
     */
    @Test
    public void replaceAndRemoveTest() {
        Strings a = new Strings();
        char[] s = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'B', 'a', 'h', 'a', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        Assert.assertEquals("Hello ddhdd", a.replaceAndRemove(s));

        s = new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'B', 'a', 'h', 'a', 'B','\u0000', '\u0000', '\u0000', '\u0000', '\u0000'};
        Assert.assertEquals("Hello ddhdd", a.replaceAndRemove(s));

        s = new char[]{'H', 'e', 'l', 'l', 'o'};
        Assert.assertEquals("Hello", a.replaceAndRemove(s));
    }

    @Test
    public void phoneNumberWordsTest() {
        Strings a = new Strings();
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

    @Test
    public void testPalindromicityTest() {
        Strings a = new Strings();
        String s1 = "A man, a plan, a canal, Panama.";
        String s2 = "Able was I, ere I saw Elba!";
        String s3 = "Ray a Ray";

        Assert.assertEquals(true, a.testPalindromicity(s1));
        Assert.assertEquals(true, a.testPalindromicity(s2));
        Assert.assertEquals(false, a.testPalindromicity(s3));
    }

}
