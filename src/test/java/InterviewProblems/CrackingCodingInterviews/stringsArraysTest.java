package InterviewProblems.CrackingCodingInterviews;

import org.junit.Assert;
import org.testng.annotations.*;

public class stringsArraysTest {

    @Test
    public void stringDuplicateChar() throws Exception {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isStringUniqueChars("aba");
        Assert.assertFalse("There are duplicate characters. Method should return false" ,b);

        b = sa.isStringUniqueChars("abcd");
        Assert.assertTrue("There are no duplicate characters. Method should return true" ,b);
    }

    @Test
    public void stringReverseEven() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.reverseString("abcd");
        Assert.assertEquals("dcba",s);

        s = sa.reverseString("abcde");
        Assert.assertEquals("edcba", s);
    }

    @Test
    public void stringAnagramPositive() throws Exception {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isAnagram("abcde", "edcba");
        Assert.assertTrue("Two strings are not anagram. Positive case fails.", b);

        b = sa.isAnagram("abcde", "cdeaa");
        Assert.assertFalse("Two strings are not anagram. Negative case fails.", b);
    }

    @Test
    public void stringReplaceAllSpace() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.replaceSpaceChars("Mr John Smith");
        Assert.assertEquals("Mr%20John%20Smith", s);
    }

    @Test
    public void editOneCharTest() {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isEditByOneChar("pale", "ple");
        Assert.assertEquals(true, b);

        b = sa.isEditByOneChar("pales", "pale");
        Assert.assertEquals(true, b);

        b = sa.isEditByOneChar("pale", "bale");
        Assert.assertEquals(true, b);

        b = sa.isEditByOneChar("pale", "bake");
        Assert.assertEquals(false, b);
    }

    @Test
    public void stringGoodCompression() throws Exception {
        StringsArrays sa = new StringsArrays();
        String s = sa.stringCompression("aabcccccaaa");
        Assert.assertEquals("a2b1c5a3", s);

        s = sa.stringCompression("abcde");
        Assert.assertEquals("abcde", s);
    }

    @Test
    public void isRotationTest() {
        StringsArrays sa = new StringsArrays();
        boolean b = sa.isRotation("waterbottle", "erbottlewat");
        Assert.assertEquals(true, b);

        b = sa.isRotation("waterbottle", "waterbottle");
        Assert.assertEquals(true, b);

        b = sa.isRotation("waterbottle", "erbotlewatt");
        Assert.assertEquals(false, b);
    }

    @Test
    public void rotationTest() {
        StringsArrays sa = new StringsArrays();

        int[][] multi = new int[][]{
                { 1, 1, 1, 1},
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 }
        };
        int[][] multiActual = sa.rotateMatrixBy90Degrees(multi);
        int[][] multiExpected = new int[][]{
                { 1, 2, 3, 4 },
                { 1, 2, 3, 4 },
                { 1, 2, 3, 4 },
                { 1, 2, 3, 4 }
        };

        Assert.assertArrayEquals(multiExpected[0], multiActual[0]);
        Assert.assertArrayEquals(multiExpected[1], multiActual[1]);
        Assert.assertArrayEquals(multiExpected[2], multiActual[2]);
        Assert.assertArrayEquals(multiExpected[3], multiActual[3]);
    }

    @Test
    public void zeroizeTest() {
        StringsArrays sa = new StringsArrays();

        int[][] multi = new int[][]{
                { 1, 2, 3, 4 },
                { 5, 0, 0, 7 },
                { 8, 9, 2, 8 },
                { 1, 2, 3, 7 }
        };
        int[][] multiActual = sa.zeroizeRowAndColumn(multi);
        int[][] multiExpected = new int[][]{
                { 1, 0, 0, 4 },
                { 0, 0, 0, 0 },
                { 8, 0, 0, 8 },
                { 1, 0, 0, 7 }
        };

        Assert.assertArrayEquals(multiExpected[0], multiActual[0]);
        Assert.assertArrayEquals(multiExpected[1], multiActual[1]);
        Assert.assertArrayEquals(multiExpected[2], multiActual[2]);
        Assert.assertArrayEquals(multiExpected[3], multiActual[3]);
    }
}
