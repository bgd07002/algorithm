package DataStructures.Maps;

import org.junit.Assert;
import org.testng.annotations.Test;

public class MapsTest {

    @Test
    public void mapsSeparateChainingTest() {
        int loadFactor = 2;
        IMap<Integer,String> map = new SeparateChainingHashTable<>(loadFactor);
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
        map.put(11, "Onbir");
        map.put(12, "Oniki");

        map.put(13, "Onuc");
        map.put(14, "Ondort");
        map.put(15, "Onbes");
        map.put(16, "Onalti");
        Assert.assertEquals(16, map.getSize());
        Assert.assertEquals("Yedi", map.get(7));
        Assert.assertEquals(null, map.get(18));

        Assert.assertEquals("Sekiz", map.get(8));
        Assert.assertEquals("Dort", map.get(4));
        Assert.assertEquals("4, 8, 12, 16, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15,", map.printKeys());

        map.remove(3);
        map.remove(8);
        map.remove(7);
        Assert.assertEquals(13, map.getSize());
        map.remove(2);
        map.remove(11);
        map.remove(4);
        map.remove(1);
        map.remove(6);
        Assert.assertEquals("12, 16, 10, 14, 5, 9, 13, 15,", map.printKeys());
    }

    @Test
    public void mapsQuadraticProbingTest() {
        IMap<Integer,String> map = new QuadraticProbingHashTable<>(1<<12 -1);
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
        Assert.assertEquals("1 2 3 4 5 6 7 8 9 10", map.printKeys());
        Assert.assertEquals("Bir Iki Uc Dort Bes Alti Yedi Sekiz Dokuz On", map.printValues());

        map.remove(3);
        map.remove(8);
        map.remove(7);
        Assert.assertEquals(7, map.getSize());
        Assert.assertEquals("1 2 4 5 6 9 10", map.printKeys());
    }
}
