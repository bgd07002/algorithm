package InterviewProblems.ElementsOfProgrammingInterviews;

import org.junit.Assert;
import org.testng.annotations.*;

import java.util.PriorityQueue;

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
    }

    @Test
    public void reverseBitsTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(0, p.reverseBits(0));
        //String hex = "ffffffff";
        //int value = Integer.parseInt(hex, 16);

        //hex = Integer.valueOf("7FFFFFFF", 16).intValue();
        //System.out.println(hex);
        //System.out.println(p.reverseBits(1));
        //System.out.println(p.reverseBits(65535));
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        //Assert.assertEquals(-1, p.reverseBits(Integer.MIN_VALUE));
    }

    @Test
    public void closestIntegerSameWeightTest() {
        PrimitiveTypes p = new PrimitiveTypes();
        Assert.assertEquals(46, p.closestIntegerSameWeight(45));
        Assert.assertEquals(16, p.closestIntegerSameWeight(32));
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
}
