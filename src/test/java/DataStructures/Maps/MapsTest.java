package DataStructures.Maps;

import org.junit.Assert;
import org.testng.annotations.Test;

public class MapsTest {

    @Test
    public void mapsTest() {
        IMap<Integer,String> map = new HashTableMap<>();
        map.put(1, "Bir");
        map.put(2, "Iki");

        map.put(3, "Uc");
        map.put(4, "Dort");
        map.put(5, "Bes");
        map.put(6, "Alti");
        map.put(7, "Yedi");
        map.put(8, "Sekiz");
        map.put(9, "Dokuz");
        map.put(10, "On");
        Assert.assertEquals(10, map.getSize());
        Assert.assertEquals("Yedi", map.get(7));
        Assert.assertEquals(null, map.get(12));

        Assert.assertEquals("Sekiz", map.get(8));
        Assert.assertEquals("Dort", map.get(4));
        Assert.assertEquals("5, 10, 1, 6, 2, 7, 3, 8, 4, 9, ", map.printKeys());

        map.remove(3);
        map.remove(8);
        map.remove(7);
        Assert.assertEquals(7, map.getSize());
        Assert.assertEquals("5, 10, 1, 6, 2, 4, 9, ", map.printKeys());
    }
}
