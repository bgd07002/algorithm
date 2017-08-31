package InterviewProblems.CrackingCodingInterviews;

import org.junit.Assert;
;import org.testng.annotations.Test;

public class BitManipulationTest {

    @Test
    public void setNSubsetsOfMTest() {
        BitManipulation b = new BitManipulation();
        int output = b.setNSubsetsOfM(1024, 21, 2, 6);
        Assert.assertEquals("10001010100", Integer.toBinaryString(output));
    }

    @Test
    public void decimalInBinaryTest() {
        BitManipulation b = new BitManipulation();
        String output = b.decimalInBinary(0.972);
        Assert.assertEquals("100101110010", output);
    }

    @Test
    public void flipBitToWinTest() {
        BitManipulation b = new BitManipulation();
        int flipBitToWin = b.flipBitToWin(1775);
        Assert.assertEquals(8, flipBitToWin);

        flipBitToWin = b.flipBitToWin(487);
        Assert.assertEquals(5, flipBitToWin);
    }

    @Test
    public void minMaxSameBitsTest() {
        BitManipulation b = new BitManipulation();
        int[] output = b.minMaxSameBits(1108);
        Assert.assertArrayEquals(new int[]{15,1920}, output);

        output = b.minMaxSameBits(0);
        Assert.assertArrayEquals(new int[]{0,0}, output);
    }

    @Test
    public void numBitsToConvertTest() {
        BitManipulation b = new BitManipulation();
        int convertBits = b.numBitsToConvert(31,14);
        Assert.assertEquals(2, convertBits);

        convertBits = b.numBitsToConvert(25,25);
        Assert.assertEquals(0,convertBits);
    }

    @Test
    public void swapOddEvenBitsTest() {
        BitManipulation b = new BitManipulation();
        int output = b.swapOddEvenBits(7);
        Assert.assertEquals(11, output);
    }
}
