package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.*;

public class PrimitiveTypesTest {

    @Test
    public void computeParityTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(0, p.computeParity(45L));
        Assert.assertEquals(1, p.computeParity(-45L));
        Assert.assertEquals(1, p.computeParity(47L));
        Assert.assertEquals(0, p.computeParity(-47L));
        Assert.assertEquals(0, p.computeParity(0L));
    }

    @Test
    public void swapBitsTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(45, p.swapBits(45, 2,3));
        Assert.assertEquals(43, p.swapBits(45, 1,2));
        Assert.assertEquals(29, p.swapBits(45, 4,5));
        //32, 16, 8, 4, 2, 1
        //1   0   1  1  0  1
    }

    @Test
    public void reverseBitsTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(0, p.reverseBits(0));
        Assert.assertEquals(-1, p.reverseBits(-1));

        String hex = "fffffff";
        int value = Integer.parseInt(hex, 16);

        System.out.println(p.reverseBits(value));
        System.out.println(p.reverseBits(1));
        System.out.println(p.reverseBits(-1));
        System.out.println(p.reverseBits(65535));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(p.reverseBits(Integer.MAX_VALUE));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(p.reverseBits(Integer.MIN_VALUE));
    }

    @Test
    public void closestIntegerSameWeightTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(46, p.closestIntegerSameWeight(45));
        Assert.assertEquals(16, p.closestIntegerSameWeight(32));
        Assert.assertEquals(30, p.closestIntegerSameWeight(15));
        Assert.assertEquals(-1, p.closestIntegerSameWeight(0));
    }

    @Test
    public void powerSetTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        String expected = "0, A, B, AB, C, AC, BC, ABC";
        Assert.assertEquals(expected, p.powerSet(new String[]{"A", "B", "C"}));
    }

    @Test
    public void stringIntegerEncodingTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(123, p.stringIntegerEncoding("123"));
        Assert.assertEquals(-123, p.stringIntegerEncoding("-123"));
        Assert.assertEquals(1000, p.stringIntegerEncoding("1000"));
        Assert.assertEquals(-1, p.stringIntegerEncoding("123abc"));
        Assert.assertEquals(0, p.stringIntegerEncoding("0"));
    }

    @Test
    public void baseConversionTest() {
        PrimitiveTypes p = new PrimitiveTypes();
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

    @Test
    public void spreadsheetEncodingTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals("ABC", p.spreadsheetEncoding(730));
        Assert.assertEquals("CD", p.spreadsheetEncoding(81));
        Assert.assertEquals("Y", p.spreadsheetEncoding(24));
    }

    @Test
    public void eliasGammaEncodingTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals("00011010011100101", p.eliasGammaEncoding(new int[] {13,7,5}));
        Assert.assertEquals("000110100101", p.eliasGammaEncoding(new int[] {13,0,5}));

        int[] decodedArr = p.eliasGammaDecoding("00011010011100101");
        Assert.assertEquals(13, decodedArr[0]);
        Assert.assertEquals(7, decodedArr[1]);
        Assert.assertEquals(5, decodedArr[2]);
    }

    @Test
    public void isIntegerPalindromeTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(true, p.isIntegerPalindrome(123321));
        Assert.assertEquals(true, p.isIntegerPalindrome(12321));
        Assert.assertEquals(false, p.isIntegerPalindrome(12345321));
    }

    @Test
    public void rectangeIntersectionTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        PrimitiveTypes.Rectangle r1 = p.new Rectangle(1,1,3,4);
        PrimitiveTypes.Rectangle r2 = p.new Rectangle(3,4,5,6);

        Assert.assertEquals(true, p.isRectanglesIntersect(r1,r2));

        PrimitiveTypes.Rectangle r3 = p.new Rectangle(4,5,3,3);
        Assert.assertEquals(false, p.isRectanglesIntersect(r1,r3));
    }
}
