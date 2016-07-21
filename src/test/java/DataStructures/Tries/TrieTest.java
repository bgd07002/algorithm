package DataStructures.Tries;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TrieTest {

    @Test
    public void trieTest() {
        Trie t = new Trie();
        t.addString("aircraft");
        t.addString("airplane");
        t.addString("bar");
        t.addString("bicycle");
        t.addString("birch");
        t.addString("bird");
        t.addString("bottle");
        t.addString("cork");
        t.addString("corn");

        Assert.assertEquals(true, t.hasString("birch"));
        Assert.assertEquals(false, t.hasString("bi"));
        Assert.assertEquals(false, t.hasString("bottler"));

        Assert.assertEquals(true, t.removeString("airplane"));
        Assert.assertEquals(false, t.removeString("airplane"));
    }
}
