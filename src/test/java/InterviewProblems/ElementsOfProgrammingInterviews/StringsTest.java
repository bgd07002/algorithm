package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class StringsTest {

    /**
     * 7.1
     */
    @Test
    public void stringIntegerEncodingTest() {
        Strings p = new Strings();
        Assert.assertEquals(123, p.stringIntegerEncoding("123"));
        Assert.assertEquals(-123, p.stringIntegerEncoding("-123"));
        Assert.assertEquals(1000, p.stringIntegerEncoding("1000"));
        Assert.assertEquals(-1, p.stringIntegerEncoding("123abc"));
        Assert.assertEquals(0, p.stringIntegerEncoding("0"));
    }

    /**
     * 7.2
     */
    @Test
    public void baseConversionTest() {
        Strings p = new Strings();
        int num = 347;
        Assert.assertEquals("101011011", p.baseConversion(num, 2));
        Assert.assertEquals("110212", p.baseConversion(num, 3));
        Assert.assertEquals("533", p.baseConversion(num, 8));
        Assert.assertEquals("347", p.baseConversion(num, 10));
        Assert.assertEquals("15B", p.baseConversion(num, 16));

        num = -347;
        Assert.assertEquals("-101011011", p.baseConversion(num, 2));
        Assert.assertEquals("-110212", p.baseConversion(num, 3));
        Assert.assertEquals("-533", p.baseConversion(num, 8));
        Assert.assertEquals("-347", p.baseConversion(num, 10));
        Assert.assertEquals("-15B", p.baseConversion(num, 16));
    }

    /**
     * 7.3
     */
    @Test
    public void spreadsheetEncodingTest() {
        Strings p = new Strings();
        Assert.assertEquals("ABC", p.spreadsheetEncoding(730));
        Assert.assertEquals("CD", p.spreadsheetEncoding(81));
        Assert.assertEquals("Y", p.spreadsheetEncoding(24));
    }

    /**
     * 7.4 Replace and remove
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

    /**
     * 7.5
     */
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

    /**
     * 7.6 Reverse All Words
     */
    @Test
    public void reverseAllWordsTest() {
        Strings a = new Strings();
        Assert.assertEquals("Bob Likes Alice", a.reverseWords("Alice Likes Bob"));
        Assert.assertEquals("d c b a", a.reverseWords("a b c d"));
        Assert.assertEquals("abcd", a.reverseWords("abcd"));
    }

    /**
     * 7.7
     */
    @Test
    public void phoneNumberWordsTest() {
        Strings a = new Strings();
        ArrayList<StringBuilder> list = a.phoneNumberWords(new int[]{1,3,4});

        Assert.assertEquals("DG", list.get(0).toString());
        Assert.assertEquals("EG", list.get(1).toString());
        Assert.assertEquals("FG", list.get(2).toString());
        Assert.assertEquals("DH", list.get(3).toString());
        Assert.assertEquals("EH", list.get(4).toString());
        Assert.assertEquals("FH", list.get(5).toString());
        Assert.assertEquals("DI", list.get(6).toString());
        Assert.assertEquals("EI", list.get(7).toString());
        Assert.assertEquals("FI", list.get(8).toString());
    }

    /**
     * 7.11
     */
    @Test
    public void stringSinusoidallyTest() {
        Strings s = new Strings();
        Assert.assertEquals("HOREL OLLWD", s.stringSinusoidally("HELLO WORLD",3));
        Assert.assertEquals("HWE OLORDLL", s.stringSinusoidally("HELLO WORLD",4));
    }

    /**
     * 7.13 Find first substring
     */
    @Test
    public void findFirstOccurenceStringTest() {
        Strings a = new Strings();
        Assert.assertEquals(9, a.findFirstOccurenceString("the", "Istanbul the pazar the pijama the"));
        Assert.assertEquals(-1, a.findFirstOccurenceString("the", "Istanbul t th pazar pijama "));
        Assert.assertEquals(0, a.findFirstOccurenceString("the", "the "));
    }
}
