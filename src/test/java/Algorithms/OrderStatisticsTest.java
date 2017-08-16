package Algorithms;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderStatisticsTest {

    @Test
    public void smallestKItemTest() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 3, 12, 9, 7, 14, 2, 5, 10));
        OrderStatistics<Integer> o = new OrderStatistics<>(list);
        Assert.assertEquals(2, (int)o.smallestKItem(1));
        Assert.assertEquals(3, (int)o.smallestKItem(2));
        Assert.assertEquals(5, (int)o.smallestKItem(3));
        Assert.assertEquals(6, (int)o.smallestKItem(4));
        Assert.assertEquals(7, (int)o.smallestKItem(5));
        Assert.assertEquals(9, (int)o.smallestKItem(6));
        Assert.assertEquals(10, (int)o.smallestKItem(7));
        Assert.assertEquals(12, (int)o.smallestKItem(8));
        Assert.assertEquals(14, (int)o.smallestKItem(9));
    }
}
