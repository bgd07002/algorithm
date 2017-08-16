package Algorithms.StringPatternMatching;

import org.junit.Assert;
import org.testng.annotations.Test;

public class StringSearchTest {

    @Test
    public void bruteForceSearchTest() {
        StringSearch s = new StringSearch();
        String str = "WHICH FINALLY HALTS.  AT THAT POINT...";
        String p = "AT THAT";
        Assert.assertEquals(22, s.bruteForceSearch(str, p));

        str = "AT THAT WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT";
        Assert.assertEquals(0, s.bruteForceSearch(str, p));

        str = "AT THAT WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT1";
        Assert.assertEquals(-1, s.bruteForceSearch(str, p));
    }

    @Test
    public void knuthMorrisPrattSearchTest() {
        StringSearch s = new StringSearch();
        String str = "WHICH FINALLY HALTS.  AT THAT POINT...";
        String p = "AT THAT";
        Assert.assertEquals(22, s.knuthMorrisPrattSearch(str, p));

        str = "AT THAT WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT";
        Assert.assertEquals(0, s.knuthMorrisPrattSearch(str, p));

        str = "AABACAABABACAA";
        p = "ABABAC";
        Assert.assertEquals(6, s.knuthMorrisPrattSearch(str, p));

        str = "AT THAT WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT1";
        Assert.assertEquals(-1, s.knuthMorrisPrattSearch(str, p));
    }

    @Test
    public void rabinKarpSearchTest() {
        StringSearch s = new StringSearch();
        String str = "3141592653589793";
        String p = "26535";
        Assert.assertEquals(6, s.rabinKarpSearch(str, p));

        str = "WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT";
        Assert.assertEquals(22, s.rabinKarpSearch(str, p));

        str = "AT THAT WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT";
        Assert.assertEquals(0, s.rabinKarpSearch(str, p));

        str = "AABACAABABACAA";
        p = "ABABAC";
        Assert.assertEquals(6, s.rabinKarpSearch(str, p));

        str = "AT THAT WHICH FINALLY HALTS.  AT THAT POINT...";
        p = "AT THAT1";
        Assert.assertEquals(-1, s.rabinKarpSearch(str, p));
    }
}
