package Algorithms.CompressionAlgorithms;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class HuffmanCompressionTest {

    @Test
    public void huffmanCodingTest() throws IOException {
        String plaintext = "aaaaabbbbbbbbbccccccccccccdddddddddddddeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffffffffffff";
        HuffmanCompression h = new HuffmanCompression(plaintext);
        String expectedCompressedString = "11001100110011001100110111011101110111011101110111011101100100100100100100100100100100100100101101101101101101101101101101101101101111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000";
        Assert.assertEquals(expectedCompressedString, h.encode());
        Assert.assertEquals(plaintext, h.decode(expectedCompressedString));

        plaintext = "a";
        h = new HuffmanCompression(plaintext);
        Assert.assertEquals("", h.encode());

        plaintext = "aaaaaaaaaab";
        h = new HuffmanCompression(plaintext);
        Assert.assertEquals("11111111110", h.encode());
        Assert.assertEquals("aaaaaaaaaab", h.decode("11111111110"));

    }

}
