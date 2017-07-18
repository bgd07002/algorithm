package Courses.UW143Spring16.HW8_HuffmanCoding;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class HuffmanCodingTest {

    @Test
    public void huffmanCodingTest() throws IOException {
        String plaintext = "ab ab cab";
        HuffmanCoding h = new HuffmanCoding(plaintext);
        Assert.assertEquals("1110011111001100111110", h.encode(plaintext));
        Assert.assertEquals("ab ab cab", h.decode("1110011111001100111110"));

        plaintext = "a";
        h = new HuffmanCoding(plaintext);
        Assert.assertEquals("1", h.encode(plaintext));
        //System.out.println(h.encode(plaintext));
    }

}
