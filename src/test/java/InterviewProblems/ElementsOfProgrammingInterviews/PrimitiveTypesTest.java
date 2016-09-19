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
        Assert.assertEquals(45L, p.swapBits(45, 2,3));
        Assert.assertEquals(43L, p.swapBits(45, 1,2));
        Assert.assertEquals(29L, p.swapBits(45, 4,5));
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
    }
}
