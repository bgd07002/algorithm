package InterviewProblems;

import InterviewProblems.StringsArrays;
import org.junit.Assert;
import org.testng.annotations.*;

public class stringsArraysTest {

    @Test
    public void stringDuplicateChar() throws Exception {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isStringUniqueChars("aba");
        Assert.assertFalse("There are duplicate characters. Method should return false" ,b);
    }

    @Test
    public void stringUniqueChar() throws Exception {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isStringUniqueChars("abcd");
        Assert.assertTrue("There are no duplicate characters. Method should return true" ,b);
    }

    @Test
    public void stringReverseEven() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.reverseString("abcd");
        Assert.assertEquals("dcba",s);
    }

    @Test
    public void stringReverseOdd() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.reverseString("abcde");
        Assert.assertEquals("edcba", s);
    }

    @Test
    public void stringAnagramPositive() throws Exception {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isAnagram("abcde", "edcba");
        Assert.assertTrue("Two strings are not anagram. Positive case fails.", b);
    }

    @Test
    public void stringAnagramNegative() throws Exception {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isAnagram("abcde", "cdeaa");
        Assert.assertFalse("Two strings are not anagram. Negative case fails.", b);
    }

    @Test
    public void stringReplaceAllSpace() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.replaceSpaceChars("Mr John Smith");
        Assert.assertEquals("Mr%20John%20Smith", s);
    }

    @Test
    public void stringGoodCompression() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.stringCompression("aabcccccaaa");
        Assert.assertEquals("a2b1c5a3", s);
    }

    @Test
    public void stringBadCompression() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.stringCompression("abcde");
        Assert.assertEquals("abcde", s);
    }
}
