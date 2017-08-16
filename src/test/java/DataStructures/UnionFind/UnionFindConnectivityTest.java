package DataStructures.UnionFind;

import org.junit.Assert;
import org.testng.annotations.Test;

public class UnionFindConnectivityTest {

    @Test
    public void unionFindTest() {
        int[] connectivityVector = {0,1,2,2,1,1,2,2};
        UnionFindConnectivity u = new UnionFindConnectivity(connectivityVector);
        Assert.assertEquals(false, u.connected(3,4));
        u.union(2,5);
        Assert.assertEquals(true, u.connected(1,6));
        Assert.assertEquals(false, u.connected(0,7));
    }
}
