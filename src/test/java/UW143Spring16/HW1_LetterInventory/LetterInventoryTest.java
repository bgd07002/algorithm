package UW143Spring16.HW1_LetterInventory;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LetterInventoryTest {

    @Test
    public void letterInventoryTest() throws Exception {

        LetterInventory inventory1 = new LetterInventory("George W. Bush");
        LetterInventory inventory2 = new LetterInventory("Hillary Clinton 123$");

        LetterInventory sum = inventory1.add(inventory2);
        LetterInventory substract = inventory2.subtract(inventory1);

        Assert.assertEquals("[beegghorsuw]", inventory1.toString());
        Assert.assertEquals("[achiilllnnorty]", inventory2.toString());

        Assert.assertEquals(3, inventory2.get('l'));
        Assert.assertEquals(14, inventory2.size());

        //Test sum
        Assert.assertEquals("[abceegghhiilllnnoorrstuwy]", sum.toString());
        Assert.assertEquals("[aciilllnnty]" , substract.toString());
    }
}
