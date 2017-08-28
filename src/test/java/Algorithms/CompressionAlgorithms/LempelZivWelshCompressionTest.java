package Algorithms.CompressionAlgorithms;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LempelZivWelshCompressionTest {

    @Test
    public void lempelZivWelshCompressionTest() {
        LempelZivWelshCompression z = new LempelZivWelshCompression();
        String plaintext = "BABAABAAA";
        String expectedCompression = "000001000010000001000001000100000000000100000001000100000010000001000001";
        Assert.assertEquals(expectedCompression, z.compress(plaintext));
        Assert.assertEquals(plaintext, z.decompress(expectedCompression));
    }
}
